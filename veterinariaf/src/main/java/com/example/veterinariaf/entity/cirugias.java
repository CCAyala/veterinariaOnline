package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cirugias")
public class cirugias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int idCirugia;
  @Column(nullable = false,length = 100)
  private String nombre;

  @Column(nullable = false, length = 250)
  private String tipoCirugia;

  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JsonIgnore
  @JoinTable(
    name = "cita_cirugia",
    joinColumns = @JoinColumn(name = "idCirugia", referencedColumnName = "idCirugia"),
    inverseJoinColumns = @JoinColumn(name = "codMasco",referencedColumnName = "codmasco")

  )
  private List<mascota> mascotaList;


  public cirugias(int idCirugia, String nombre, String tipoCirugia) {
    this.idCirugia = idCirugia;
    this.nombre = nombre;
    this.tipoCirugia = tipoCirugia;
  }

  public cirugias() {
  }

  public int getIdCirugia() {
    return idCirugia;
  }

  public void setIdCirugia(int idCirugia) {
    this.idCirugia = idCirugia;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipoCirugia() {
    return tipoCirugia;
  }

  public void setTipoCirugia(String tipoCirugia) {
    this.tipoCirugia = tipoCirugia;
  }

  public List<mascota> getMascotaList() {
    return mascotaList;
  }

  public void setMascotaList(List<mascota> mascotaList) {
    this.mascotaList = mascotaList;
  }
}
