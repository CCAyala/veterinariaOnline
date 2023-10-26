package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "cita_laboratorio")
public class cita_laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCitaLabora;

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
    @JoinColumn(name = "idlaboratorio")
    @JsonIgnore
    private Laboratorio laboratorio;


    public cita_laboratorio(int idCitaLabora, Date fechaCita, Time hora) {
        this.idCitaLabora = idCitaLabora;
        this.fechaCita = fechaCita;
        this.hora = hora;
    }


    public cita_laboratorio() {
    }

    public int getIdCitaLabora() {
        return idCitaLabora;
    }

    public void setIdCitaLabora(int idCitaLabora) {
        this.idCitaLabora = idCitaLabora;
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

    public veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public com.example.veterinariaf.entity.mascota getMascota() {
        return mascota;
    }

    public void setMascota(com.example.veterinariaf.entity.mascota mascota) {
        this.mascota = mascota;
    }
}
