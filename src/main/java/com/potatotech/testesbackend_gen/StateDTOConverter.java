package com.potatotech.testesbackend_gen;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.UUID;

@Component
public class StateDTOConverter {

        public StateEntity toEntity(StateDTO dto){
            return new StateEntity(dto.id(), dto.name(), dto.code(), null);
        }

        public StateDTO toDTO(StateEntity entity){
            return new StateDTO(entity.getId(), entity.getName(), entity.getCode());
        }

        public List<StateEntity> toEntity(List<StateDTO> obj){
            var list = new ArrayList<StateEntity>();
            obj.forEach(dto -> {
                var entity = new StateEntity(dto.id(), dto.name(), dto.code(), null);
                list.add(entity);
            });
            return list;
        }

        public List<StateDTO> toDTO(List<StateEntity> obj){
            var list = new ArrayList<StateDTO>();
            obj.forEach(entity -> {
                var dto = new StateDTO(entity.getId(), entity.getName(), entity.getCode());
                list.add(dto);
            });
            return list;
        }
}
