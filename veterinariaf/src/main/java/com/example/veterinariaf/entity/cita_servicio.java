package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "cita_servicio")
public class cita_servicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCitaServi;

    private Date fechaCita;
    private Time hora;


    @ManyToOne
    @JoinColumn(name = "codMasco") // Nombre de la columna en la base de datos
    @JsonIgnore
    private mascota mascota;


    @ManyToOne
    @JoinColumn(name = "id_Veterinario")
    @JsonIgnore
    private veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    @JsonIgnore
    private servicios servicios;


    public cita_servicio(int idCitaServi, Date fechaCita, Time hora) {
        this.idCitaServi = idCitaServi;
        this.fechaCita = fechaCita;
        this.hora = hora;
    }

    public cita_servicio() {
    }

    public int getIdCitaServi() {
        return idCitaServi;
    }

    public void setIdCitaServi(int idCitaServi) {
        this.idCitaServi = idCitaServi;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public com.example.veterinariaf.entity.mascota getMascota() {
        return mascota;
    }

    public void setMascota(com.example.veterinariaf.entity.mascota mascota) {
        this.mascota = mascota;
    }

    public com.example.veterinariaf.entity.veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(com.example.veterinariaf.entity.veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public com.example.veterinariaf.entity.servicios getServicios() {
        return servicios;
    }

    public void setServicios(com.example.veterinariaf.entity.servicios servicios) {
        this.servicios = servicios;
    }
}
