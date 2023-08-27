package com.potatotech.testesbackend_gen;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("country")
public class CountryHandler implements HandlerBase<CountryDTO, UUID> {

    @Autowired
    CountryRepository repository;

    @Override
    public CountryDTO save(CountryDTO obj) {
        return null;
    }

    @Override
    public CountryDTO update(CountryDTO obj, UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CountryDTO get(UUID id) {
        return null;
    }

    @Override
    public List<ResponseData> getAll(RequestData obj) {
        return null;
    }
}
