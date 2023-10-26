package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propietario")
public class propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 250)
    private String nombre_completo;
    @Column(nullable = false)
    private int cedula;
    @Column(nullable = false,length = 255)
    private String ocupacion;
    @Column(nullable = false,length = 10)
    private String celular;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "propietario",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<mascota> mascotas;

    public propietario(int id, String nombre_completo, int cedula, String ocupacion, String celular) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.celular = celular;
    }

    public propietario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
