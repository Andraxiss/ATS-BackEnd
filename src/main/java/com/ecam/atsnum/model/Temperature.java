package com.ecam.atsnum.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "temperatures")
@AttributeOverride(name = "id", column = @Column(name = "temperatures_id"))
public class Temperature extends GenericTableModel {

    private float temperatureSortie;
    private float temperatureEntree;


}
