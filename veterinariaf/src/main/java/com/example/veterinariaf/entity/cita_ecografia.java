package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "cita_ecografia")
public class cita_ecografia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEcografia;

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
    @JoinColumn(name = "idEcogra")

    @JsonIgnore
    private ecografia ecografia;


    public cita_ecografia(int idEcografia, Date fechaCita, Time hora) {
        this.idEcografia = idEcografia;
        this.fechaCita = fechaCita;
        this.hora = hora;
    }

  public cita_ecografia() {
  }

  public int getIdEcografia() {
        return idEcografia;
    }

    public void setIdEcografia(int idEcografia) {
        this.idEcografia = idEcografia;
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

    public com.example.veterinariaf.entity.ecografia getEcografia() {
        return ecografia;
    }

    public void setEcografia(com.example.veterinariaf.entity.ecografia ecografia) {
        this.ecografia = ecografia;
    }
}
