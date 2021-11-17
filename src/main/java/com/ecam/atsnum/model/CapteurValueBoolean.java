package com.ecam.atsnum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class CapteurValueBoolean {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int capteurValueBooleanId;
    private boolean capteurValueBooleanValue;
    private int machineId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC+1")
    private LocalDateTime dateReleve;
    @ManyToOne
    private Capteur capteur;
}
