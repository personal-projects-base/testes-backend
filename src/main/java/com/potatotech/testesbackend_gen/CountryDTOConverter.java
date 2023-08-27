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
public class CountryDTOConverter {

    

    public CountryEntity toEntity(CountryDTO dto){

        var entity = new CountryEntity();
        
        entity.setId(dto.id);
        entity.setName(dto.name);
        entity.setCode(dto.code);


        return entity;
    }

    public CountryDTO toDTO(CountryEntity entity){

        var dto = new CountryDTO();
        
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.code = entity.getCode();

        return dto;
    }

    public List<CountryEntity> toEntity(List<CountryDTO> obj){
        var list = new ArrayList<CountryEntity>();
        obj.forEach(dto -> {
            var entity = toEntity(dto);
            list.add(entity);
        });
        return list;
    }

    public List<CountryDTO> toDTO(List<CountryEntity> obj){
        var list = new ArrayList<CountryDTO>();
        obj.forEach(entity -> {
            var dto = toDTO(entity);
            list.add(dto);
        });
        return list;
    }
}
