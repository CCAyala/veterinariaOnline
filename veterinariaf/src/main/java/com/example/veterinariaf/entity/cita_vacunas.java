package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "cita_vacunas")
public class cita_vacunas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCitaVacuna;

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
    @JoinColumn(name = "idVacuna")
    @JsonIgnore
    private vacunas vacunas;

    public cita_vacunas(int idCitaVacuna, Date fechaCita, Time hora) {
        this.idCitaVacuna = idCitaVacuna;
        this.fechaCita = fechaCita;
        this.hora = hora;
    }

    public cita_vacunas() {
    }

    public int getIdCitaVacuna() {
        return idCitaVacuna;
    }

    public void setIdCitaVacuna(int idCitaVacuna) {
        this.idCitaVacuna = idCitaVacuna;
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

    public com.example.veterinariaf.entity.vacunas getVacunas() {
        return vacunas;
    }

    public void setVacunas(com.example.veterinariaf.entity.vacunas vacunas) {
        this.vacunas = vacunas;
    }
}
