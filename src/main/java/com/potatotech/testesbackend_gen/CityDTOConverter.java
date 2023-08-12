package com.potatotech.testesbackend_gen;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.UUID;

@Component
public class CityDTOConverter {

        public CityEntity toEntity(CityDTO dto){
            return new CityEntity(dto.id(), dto.name(), dto.code(), null);
        }

        public CityDTO toDTO(CityEntity entity){
            return new CityDTO(entity.getId(), entity.getName(), entity.getCode());
        }

        public List<CityEntity> toEntity(List<CityDTO> obj){
            var list = new ArrayList<CityEntity>();
            obj.forEach(dto -> {
                var entity = new CityEntity(dto.id(), dto.name(), dto.code(), null);
                list.add(entity);
            });
            return list;
        }

        public List<CityDTO> toDTO(List<CityEntity> obj){
            var list = new ArrayList<CityDTO>();
            obj.forEach(entity -> {
                var dto = new CityDTO(entity.getId(), entity.getName(), entity.getCode());
                list.add(dto);
            });
            return list;
        }
}
