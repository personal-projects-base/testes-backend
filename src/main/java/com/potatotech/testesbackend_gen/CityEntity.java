package com.potatotech.testesbackend_gen;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="city")
public class CityEntity {

    
    /**Identificador único da cidade**/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    /**Nome da cidade**/
    private String name;
    
    /**codigo da cidade**/
    private String code;
    
    /**UD**/
    @OneToOne(fetch = FetchType.LAZY)
    private StateEntity state;
    
}
