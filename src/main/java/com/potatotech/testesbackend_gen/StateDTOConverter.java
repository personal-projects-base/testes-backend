package com.potatotech.testesbackend_gen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.UUID;

@Component
public class StateDTOConverter {

    
    @Autowired
    CountryDTOConverter countryDtoConverter;

    public StateEntity toEntity(StateDTO dto){

        var entity = new StateEntity();
        
        entity.setId(dto.id);
        entity.setName(dto.name);
        entity.setCode(dto.code);
        entity.setCountry(countryDtoConverter.toEntity(dto.country));


        return entity;
    }

    public StateDTO toDTO(StateEntity entity){

        var dto = new StateDTO();
        
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.code = entity.getCode();
        dto.country = countryDtoConverter.toDTO(entity.getCountry());

        return dto;
    }

    public List<StateEntity> toEntity(List<StateDTO> obj){
        var list = new ArrayList<StateEntity>();
        obj.forEach(dto -> {
            var entity = toEntity(dto);
            list.add(entity);
        });
        return list;
    }

    public List<StateDTO> toDTO(List<StateEntity> obj){
        var list = new ArrayList<StateDTO>();
        obj.forEach(entity -> {
            var dto = toDTO(entity);
            list.add(dto);
        });
        return list;
    }
}
