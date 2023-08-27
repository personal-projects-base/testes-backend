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
import org.springframework.web.bind.annotation.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="country")
public class CountryEntity {

    
    /**Identificador único do estado**/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    
    /**Nome do pais**/
    @Column(name = "name")
    private String name;
    
    /**codigo da pais**/
    @Column(name = "code")
    private String code;
    
}
