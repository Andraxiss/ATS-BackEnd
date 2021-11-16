package com.ecam.atsnum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class CapteurValue {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int capteurValueId;
    private double capteurValue;
    private int machineId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC+1")
    private LocalDateTime dateReleve;
    @ManyToOne
    private Capteur capteur;
}
