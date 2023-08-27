package com.potatotech.testesbackend_gen;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("state")
public class StateHandler implements HandlerBase<StateDTO, UUID> {

    @Autowired
    StateRepository repository;

    @Autowired
    StateDTOConverter dtoConverter;

    @Autowired
    SpecificationFilter<StateEntity> especificationFilter;

    @Override
    public StateDTO save(StateDTO obj) {
        var entity = dtoConverter.toEntity(obj);
        entity = repository.save(entity);
        return dtoConverter.toDTO(entity);
    }

    @Override
    public StateDTO update(StateDTO obj, UUID id) {
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
    public StateDTO get(UUID id) {
        return dtoConverter.toDTO(repository.getReferenceById(id));
    }

    @Override
    public ResponseData getAll(RequestData input) {

        Pageable pageable = PageRequest.of(input.offset, input.offset);
        var spec = especificationFilter.customFilter(input.filter);
        var ret = repository.findAll(spec, pageable);

        return null;
    }
}
