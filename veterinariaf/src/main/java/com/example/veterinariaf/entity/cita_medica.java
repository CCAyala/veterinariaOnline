package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "cita_medica")
public class cita_medica {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCitaMedica;

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
  @JoinColumn(name = "idConsulta")
  @JsonIgnore
  private consultaMedica consultaMedica;


  public cita_medica(int idCitaMedica, Date fechaCita, Time hora) {
    this.idCitaMedica = idCitaMedica;
    this.fechaCita = fechaCita;
    this.hora = hora;
  }

  public cita_medica() {
  }

  public int getIdCitaMedica() {
    return idCitaMedica;
  }

  public void setIdCitaMedica(int idCitaMedica) {
    this.idCitaMedica = idCitaMedica;
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

  public com.example.veterinariaf.entity.consultaMedica getConsultaMedica() {
    return consultaMedica;
  }

  public void setConsultaMedica(com.example.veterinariaf.entity.consultaMedica consultaMedica) {
    this.consultaMedica = consultaMedica;
  }
}
