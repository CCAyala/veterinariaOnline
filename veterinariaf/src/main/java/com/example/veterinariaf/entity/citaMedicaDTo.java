package com.example.veterinariaf.entity;

import java.sql.Date;
import java.sql.Time;

public class citaMedicaDTo {

  private Date fecha;
  private Time hora;
  private String nombreEcografia;
  private String nombreVeterinario;
  private String NombreMascota;

  public citaMedicaDTo(Date fecha, Time hora, String nombreEcografia, String nombreVeterinario, String nombreMascota) {
    this.fecha = fecha;
    this.hora = hora;
    this.nombreEcografia = nombreEcografia;
    this.nombreVeterinario = nombreVeterinario;
    NombreMascota = nombreMascota;
  }

  public citaMedicaDTo() {
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Time getHora() {
    return hora;
  }

  public void setHora(Time hora) {
    this.hora = hora;
  }

  public String getNombreEcografia() {
    return nombreEcografia;
  }

  public void setNombreEcografia(String nombreEcografia) {
    this.nombreEcografia = nombreEcografia;
  }

  public String getNombreVeterinario() {
    return nombreVeterinario;
  }

  public void setNombreVeterinario(String nombreVeterinario) {
    this.nombreVeterinario = nombreVeterinario;
  }

  public String getNombreMascota() {
    return NombreMascota;
  }

  public void setNombreMascota(String nombreMascota) {
    NombreMascota = nombreMascota;
  }
}
