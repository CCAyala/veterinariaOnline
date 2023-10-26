package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "planMejoramiento")
public class planMejoramiento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id_formula;

  private Date fecha;

  private String Descripcion;

  private int cantidad;

  private String incapacidad;

  @ManyToOne
  @JoinColumn(name = "id_Veterinario")
  @JsonIgnore
  private veterinario veterinario;

  @ManyToOne
  @JoinColumn(name = "id_Medicamento")
  @JsonIgnore
  private medicamentos medicamentos;

  @ManyToOne
  @JoinColumn(name = "id_diagnostico")
  @JsonIgnore
  private diagnostico diagnostico;

  public planMejoramiento(int id_formula, Date fecha, String descripcion, int cantidad, String incapacidad) {
    this.id_formula = id_formula;
    this.fecha = fecha;
    Descripcion = descripcion;
    this.cantidad = cantidad;
    this.incapacidad = incapacidad;
  }

  public planMejoramiento() {
  }

  public int getId_formula() {
    return id_formula;
  }

  public void setId_formula(int id_formula) {
    this.id_formula = id_formula;
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

  public com.example.veterinariaf.entity.veterinario getVeterinario() {
    return veterinario;
  }

  public void setVeterinario(com.example.veterinariaf.entity.veterinario veterinario) {
    this.veterinario = veterinario;
  }

  public com.example.veterinariaf.entity.diagnostico getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(com.example.veterinariaf.entity.diagnostico diagnostico) {
    this.diagnostico = diagnostico;
  }

  public com.example.veterinariaf.entity.medicamentos getMedicamentos() {
    return medicamentos;
  }

  public void setMedicamentos(com.example.veterinariaf.entity.medicamentos medicamentos) {
    this.medicamentos = medicamentos;
  }
}
