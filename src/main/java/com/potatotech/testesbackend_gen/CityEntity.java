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
@Table(name="city")
public class CityEntity {

    
    /**Identificador único da cidade**/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    
    /**Nome da cidade**/
    @Column(name = "name")
    private String name;
    
    /**codigo da cidade**/
    @Column(name = "code")
    private String code;
    
    /**UD**/
    @PrimaryKeyJoinColumn(name = "state")
    @OneToOne(fetch = FetchType.LAZY)
    private StateEntity state;
    
}
