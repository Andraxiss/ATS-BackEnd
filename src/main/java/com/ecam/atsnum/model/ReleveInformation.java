package com.ecam.atsnum.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name ="releve_information")
public class ReleveInformation {

    @Id
    @NonNull
    @Column(name = "releve_information_id" )
    private int releveInformationId;
    @Column(name = "date_releve")
    private LocalDate dateReleve;
    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;
}
