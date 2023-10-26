package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "cita_cirugia")
public class cita_cirugia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCitaCirugia;

  private Date fechaCita;
  private Time hora;


  @ManyToOne
  @JoinColumn(name = "codMasco") // Nombre de la columna en la base de datos
  @JsonIgnore
  private mascota mascota;


  @ManyToOne
  @JoinColumn(name = "id_Veterinario")
  @JsonIgnore
  private veterinario veterinario;

  @ManyToOne
  @JoinColumn(name = "idCirugia")
  @JsonIgnore
  private cirugias cirugias;

  public cita_cirugia(int idCitaCirugia, Date fechaCita, Time hora) {
    this.idCitaCirugia = idCitaCirugia;
    this.fechaCita = fechaCita;
    this.hora = hora;
  }

  public cita_cirugia() {
  }

  public int getIdCitaCirugia() {
    return idCitaCirugia;
  }

  public void setIdCitaCirugia(int idCitaCirugia) {
    this.idCitaCirugia = idCitaCirugia;
  }

  public Date getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(Date fechaCita) {
    this.fechaCita = fechaCita;
  }

  public Time getHora() {
    return hora;
  }

  public void setHora(Time hora) {
    this.hora = hora;
  }

  public com.example.veterinariaf.entity.mascota getMascota() {
    return mascota;
  }

  public void setMascota(com.example.veterinariaf.entity.mascota mascota) {
    this.mascota = mascota;
  }

  public com.example.veterinariaf.entity.veterinario getVeterinario() {
    return veterinario;
  }

  public void setVeterinario(com.example.veterinariaf.entity.veterinario veterinario) {
    this.veterinario = veterinario;
  }

  public com.example.veterinariaf.entity.cirugias getCirugias() {
    return cirugias;
  }

  public void setCirugias(com.example.veterinariaf.entity.cirugias cirugias) {
    this.cirugias = cirugias;
  }
}
