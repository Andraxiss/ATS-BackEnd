package com.ecam.atsnum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC+1")
    private LocalDateTime dateReleve;
    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;
}
