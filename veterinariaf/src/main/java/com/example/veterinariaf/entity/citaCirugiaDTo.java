package com.example.veterinariaf.entity;

import java.sql.Date;
import java.sql.Time;

public class citaCirugiaDTo {


  private Date fecha;
  private Time hora;
  private String nombreCirugia;
  private String nombreVeterinario;
  private String NombreMascota;

  public citaCirugiaDTo(Date fecha, Time hora, String nombreCirugia, String nombreVeterinario, String nombreMascota) {
    this.fecha = fecha;
    this.hora = hora;
    this.nombreCirugia = nombreCirugia;
    this.nombreVeterinario = nombreVeterinario;
    NombreMascota = nombreMascota;
  }

  public citaCirugiaDTo() {
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

  public String getNombreCirugia() {
    return nombreCirugia;
  }

  public void setNombreCirugia(String nombreCirugia) {
    this.nombreCirugia = nombreCirugia;
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


