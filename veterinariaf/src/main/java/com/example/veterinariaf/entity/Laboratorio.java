package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  int id_labora;
    @Column(nullable = false,length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String tipoPrueba;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "cita_laboratorio",
            joinColumns = @JoinColumn(name = "idlaboratorio", referencedColumnName = "id_labora"),
            inverseJoinColumns = @JoinColumn(name = "codMasco",referencedColumnName = "codmasco")

    )
    private List<mascota> mascotaList;

    public Laboratorio(int id_labora, String nombre, String tipoPrueba) {
        this.id_labora = id_labora;
        this.nombre = nombre;
        this.tipoPrueba = tipoPrueba;
    }

    public Laboratorio() {
    }

    public int getId_labora() {
        return id_labora;
    }

    public void setId_labora(int id_labora) {
        this.id_labora = id_labora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public List<mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }
}
