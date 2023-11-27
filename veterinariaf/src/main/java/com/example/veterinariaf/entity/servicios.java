package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "servicios")
public class servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idServicio;
    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false, length = 250)
    private String tipoServicio;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "cita_servicio",
            joinColumns = @JoinColumn(name = "idServicio", referencedColumnName = "idServicio"),
            inverseJoinColumns = @JoinColumn(name = "codMasco",referencedColumnName = "codmasco")

    )
    private List<mascota> mascotaList;

    public servicios(int idServicio, String nombre, String tipoServicio, List<mascota> mascotaList) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.mascotaList = mascotaList;
    }

    public servicios() {
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }
}
