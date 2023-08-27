package com.potatotech.testesbackend.handler;

import com.potatotech.testesbackend_gen.ListCity;
import com.potatotech.testesbackend_gen.ListCityInput;
import com.potatotech.testesbackend_gen.ListCityOutput;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class CityHandlerImpl implements ListCity {
    @Override
    public ListCityOutput listCity(ListCityInput input) {
        var a = new ListCityOutput();
        a.city = Collections.emptyList();
        return a;
    }
}
