package com.potatotech.testesbackend_gen;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("city")
public class CityHandler implements HandlerBase<CityDTO, UUID> {

    @Autowired
    CityRepository repository;

    @Override
    public CityDTO save(CityDTO obj) {
        return null;
    }

    @Override
    public CityDTO update(CityDTO obj, UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CityDTO get(UUID id) {
        return null;
    }

    @Override
    public List<CityDTO> getAll(RequestData obj) {
        return null;
    }
}
