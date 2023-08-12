package com.potatotech.testesbackend.handler;

import com.potatotech.testesbackend.config.crudbase.PosatTestHandler;
import com.potatotech.testesbackend.config.crudbase.TestHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping
public class TestHandlerImpl implements TestHandler, PosatTestHandler {
    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok("OK deu boa + aqui");
    }

    @Override
    public ResponseEntity<?> saveAll(Object obj) {
        return ResponseEntity.ok(obj);
    }
}
