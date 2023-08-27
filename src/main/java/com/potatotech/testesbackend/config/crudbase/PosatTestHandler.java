package com.potatotech.testesbackend.config.crudbase;

import com.potatotech.authorization.stereotype.Anonymous;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface PosatTestHandler {

    @PostMapping("saveAll")
    @Anonymous
    public ResponseEntity<?> saveAll(@RequestBody Object obj);
}
