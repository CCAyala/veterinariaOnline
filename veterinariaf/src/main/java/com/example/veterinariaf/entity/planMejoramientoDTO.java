package com.example.veterinariaf.entity;

import java.util.Date;

public class planMejoramientoDTO {


  private Date fecha;

  private String Descripcion;

  private int cantidad;

  private String incapacidad;

  private String nombreVete;

  private String nombreMasco;

  public planMejoramientoDTO(Date fecha, String descripcion, int cantidad, String incapacidad, String nombreVete, String nombreMasco) {
    this.fecha = fecha;
    Descripcion = descripcion;
    this.cantidad = cantidad;
    this.incapacidad = incapacidad;
    this.nombreVete = nombreVete;
    this.nombreMasco = nombreMasco;
  }

  public planMejoramientoDTO() {
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String descripcion) {
    Descripcion = descripcion;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getIncapacidad() {
    return incapacidad;
  }

  public void setIncapacidad(String incapacidad) {
    this.incapacidad = incapacidad;
  }

  public String getNombreVete() {
    return nombreVete;
  }

  public void setNombreVete(String nombreVete) {
    this.nombreVete = nombreVete;
  }

  public String getNombreMasco() {
    return nombreMasco;
  }

  public void setNombreMasco(String nombreMasco) {
    this.nombreMasco = nombreMasco;
  }
}
