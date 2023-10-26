package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicamentos")
public class medicamentos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idMedicamento;
  @Column(nullable = false, length = 100)
  private String nombre;
  @Column(nullable = false, length = 200)
  private String tipoMedicamento;

  @ManyToMany(mappedBy = "ListMedicamentos")
  @JsonBackReference
  private List<diagnostico> diagnosticoList;

  public medicamentos(int idMedicamento, String nombre, String tipoMedicamento) {
    this.idMedicamento = idMedicamento;
    this.nombre = nombre;
    this.tipoMedicamento = tipoMedicamento;
  }

  public medicamentos() {
  }


  public int getIdMedicamento() {
    return idMedicamento;
  }

  public void setIdMedicamento(int idMedicamento) {
    this.idMedicamento = idMedicamento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public List<diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }


}
