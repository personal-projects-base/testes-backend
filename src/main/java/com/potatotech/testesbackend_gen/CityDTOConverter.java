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
public class CityDTOConverter {

    
    @Autowired
    StateDTOConverter stateDtoConverter;

    public CityEntity toEntity(CityDTO dto){

        var entity = new CityEntity();
        
        entity.setId(dto.id);
        entity.setName(dto.name);
        entity.setCode(dto.code);
        entity.setState(stateDtoConverter.toEntity(dto.state));


        return entity;
    }

    public CityDTO toDTO(CityEntity entity){

        var dto = new CityDTO();
        
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.code = entity.getCode();
        dto.state = stateDtoConverter.toDTO(entity.getState());

        return dto;
    }

    public List<CityEntity> toEntity(List<CityDTO> obj){
        var list = new ArrayList<CityEntity>();
        obj.forEach(dto -> {
            var entity = toEntity(dto);
            list.add(entity);
        });
        return list;
    }

    public List<CityDTO> toDTO(List<CityEntity> obj){
        var list = new ArrayList<CityDTO>();
        obj.forEach(entity -> {
            var dto = toDTO(entity);
            list.add(dto);
        });
        return list;
    }
}
