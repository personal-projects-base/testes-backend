package com.potatotech.testesbackend.config.crudbase;


import com.potatotech.authorization.stereotype.Anonymous;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface TestHandler {

    @GetMapping("getAll")
    @Anonymous
    public ResponseEntity<?> getAll();
}
