package com.potatotech.testesbackend_gen;

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
            return new CountryEntity(dto.id(), dto.name(), dto.code());
        }

        public CountryDTO toDTO(CountryEntity entity){
            return new CountryDTO(entity.getId(), entity.getName(), entity.getCode());
        }

        public List<CountryEntity> toEntity(List<CountryDTO> obj){
            var list = new ArrayList<CountryEntity>();
            obj.forEach(dto -> {
                var entity = new CountryEntity(dto.id(), dto.name(), dto.code());
                list.add(entity);
            });
            return list;
        }

        public List<CountryDTO> toDTO(List<CountryEntity> obj){
            var list = new ArrayList<CountryDTO>();
            obj.forEach(entity -> {
                var dto = new CountryDTO(entity.getId(), entity.getName(), entity.getCode());
                list.add(dto);
            });
            return list;
        }
}
