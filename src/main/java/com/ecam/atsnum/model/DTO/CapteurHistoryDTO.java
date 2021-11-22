package com.ecam.atsnum.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class CapteurHistoryDTO {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int capteurValueId;

  private double capteurValue;
  private int machineId;
  private int capteurId;
  private String capteurNom;

  public String getCapteurNom() {
    return capteurNom;
  }

  public void setCapteurNom(String capteurNom) {
    this.capteurNom = capteurNom;
  }

   private LocalDateTime dateReleve;

  public LocalDateTime getDateReleve() {
    return dateReleve;
  }

  public void setDateReleve(LocalDateTime dateReleve) {
    this.dateReleve = dateReleve;
  }

  public int getCapteurValueId() {
    return capteurValueId;
  }

  public void setCapteurValueId(int capteurValueId) {
    this.capteurValueId = capteurValueId;
  }

  public double getCapteurValue() {
    return capteurValue;
  }

  public void setCapteurValue(double capteurValue) {
    this.capteurValue = capteurValue;
  }

  public int getMachineId() {
    return machineId;
  }

  public void setMachineId(int machineId) {
    this.machineId = machineId;
  }

  public int getCapteurId() {
    return capteurId;
  }

  public void setCapteurId(int capteurId) {
    this.capteurId = capteurId;
  }

  public CapteurHistoryDTO(
      int capteurValueId,
      double capteurValue,
      int machineId,
      int capteurId,
      LocalDateTime dateReleve,
      String capteurNom) {
    this.capteurValueId = capteurValueId;
    this.capteurValue = capteurValue;
    this.machineId = machineId;
    this.capteurId = capteurId;
    this.dateReleve = dateReleve;
    this.capteurNom=capteurNom;
  }
}
