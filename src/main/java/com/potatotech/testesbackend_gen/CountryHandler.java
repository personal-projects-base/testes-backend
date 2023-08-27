package com.potatotech.testesbackend_gen;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("country")
public class CountryHandler implements HandlerBase<CountryDTO, UUID> {

    @Autowired
    CountryRepository repository;

    @Autowired
    CountryDTOConverter dtoConverter;

    @Autowired
    SpecificationFilter<CountryEntity> especificationFilter;

    @Override
    public CountryDTO save(CountryDTO obj) {
        var entity = dtoConverter.toEntity(obj);
        entity = repository.save(entity);
        return dtoConverter.toDTO(entity);
    }

    @Override
    public CountryDTO update(CountryDTO obj, UUID id) {
        var entity = dtoConverter.toEntity(obj);
        entity.setId(id);
        entity = repository.save(entity);
        return dtoConverter.toDTO(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CountryDTO get(UUID id) {
        return dtoConverter.toDTO(repository.getReferenceById(id));
    }

    @Override
    public ResponseData getAll(RequestData input) {


        if(input.offset <= 0){
            input.offset = 1;
        }
        input.offset--;
        Pageable pageable = PageRequest.of(input.offset , input.size);
        var spec = especificationFilter.customFilter(input.filter);
        var ret = repository.findAll(spec, pageable);

        var output = new ResponseData();
        output.total = Integer.parseInt(String.valueOf(ret.getTotalElements()));
        output.contents = ret.get();
        output.size = ret.getSize();
        output.offset = input.offset;
        return output;
    }
}
