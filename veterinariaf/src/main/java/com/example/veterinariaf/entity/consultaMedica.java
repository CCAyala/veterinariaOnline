package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "consultaMedica")
public class consultaMedica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int idConsulta;
  @Column(nullable = false,length = 50)
  private String nombre;

  @Column(nullable = false, length = 250)
  private String tipoCita;

  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JsonIgnore
  @JoinTable(
    name = "cita_medica",
    joinColumns = @JoinColumn(name = "idConsulta", referencedColumnName = "idConsulta"),
    inverseJoinColumns = @JoinColumn(name = "codMasco",referencedColumnName = "codmasco")

  )
  private List<mascota> mascotaList;

  public consultaMedica(int idConsulta, String nombre, String tipoCita) {
    this.idConsulta = idConsulta;
    this.nombre = nombre;
    this.tipoCita = tipoCita;
  }

  public consultaMedica() {
  }

  public int getIdConsulta() {
    return idConsulta;
  }

  public void setIdConsulta(int idConsulta) {
    this.idConsulta = idConsulta;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipoCita() {
    return tipoCita;
  }

  public void setTipoCita(String tipoCita) {
    this.tipoCita = tipoCita;
  }

  public List<mascota> getMascotaList() {
    return mascotaList;
  }

  public void setMascotaList(List<mascota> mascotaList) {
    this.mascotaList = mascotaList;
  }
}
