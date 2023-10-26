package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vacunas")
public class vacunas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idVacuna;
    @Column(nullable = false,length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String tipoVacuna;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "cita_vacunas",
            joinColumns = @JoinColumn(name = "idVacuna", referencedColumnName = "idVacuna"),
            inverseJoinColumns = @JoinColumn(name = "codMasco",referencedColumnName = "codmasco")

    )
    private List<mascota> mascotaList;


    public vacunas(int idVacuna, String nombre, String tipoVacuna) {
        this.idVacuna = idVacuna;
        this.nombre = nombre;
        this.tipoVacuna = tipoVacuna;
    }

    public vacunas() {
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public List<mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }
}
