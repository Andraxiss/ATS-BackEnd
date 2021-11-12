package com.ecam.atsnum.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "temperatures")
public class Temperature {
    @Id
    @NotNull
    private int temperaturesId;

    @OneToOne
    @JoinColumn(name = "releve_info_id", nullable = false)
    private ReleveInformation releveInformation;
    private float temperatureSortie;
    private float temperatureEntree;


}
