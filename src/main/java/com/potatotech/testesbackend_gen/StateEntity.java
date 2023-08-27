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
@Table(name="state")
public class StateEntity {

    
    /**Identificador único do estado**/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    
    /**Nome do estado**/
    @Column(name = "name")
    private String name;
    
    /**codigo da estado**/
    @Column(name = "code")
    private String code;
    
    /**Pais**/
    @PrimaryKeyJoinColumn(name = "country")
    @OneToOne(fetch = FetchType.LAZY)
    private CountryEntity country;
    
}
