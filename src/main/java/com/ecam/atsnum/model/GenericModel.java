package com.ecam.atsnum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class GenericModel {
    @Id
    @NotNull
    private int id;

    @OneToOne
    @JoinColumn(name = "releve_info_id", nullable = false)
    private ReleveInformation releveInformation;
}
