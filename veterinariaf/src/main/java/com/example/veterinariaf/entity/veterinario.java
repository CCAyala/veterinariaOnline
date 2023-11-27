package com.example.veterinariaf.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "veterinario")
public class veterinario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int cod_veterinario;
        private String nombre;

        private int cedula;
        private String especialidad;

        private String telefono;
        private String email;


    public veterinario(int cod_veterinario, String nombre, int cedula, String especialidad, String telefono, String email) {
        this.cod_veterinario = cod_veterinario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }

    public int getCod_veterinario() {
        return cod_veterinario;
    }

    public void setCod_veterinario(int cod_veterinario) {
        this.cod_veterinario = cod_veterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
