package com.potatotech.testesbackend_gen;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    
    UUID id; 
    String name; 
    String code; 
}
