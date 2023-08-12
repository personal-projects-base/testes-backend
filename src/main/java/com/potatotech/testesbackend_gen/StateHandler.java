package com.potatotech.testesbackend_gen;

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

    @Override
    public StateDTO save(StateDTO obj) {
        return null;
    }

    @Override
    public StateDTO update(StateDTO obj, UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public StateDTO get(UUID id) {
        return null;
    }

    @Override
    public List<StateDTO> getAll(RequestData obj) {
        return null;
    }
}
