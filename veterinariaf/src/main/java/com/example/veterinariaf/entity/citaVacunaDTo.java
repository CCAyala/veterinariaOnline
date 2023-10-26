package com.example.veterinariaf.entity;

import java.sql.Date;
import java.sql.Time;

public class citaVacunaDTo {

    private Date fecha;
    private Time hora;
    private String nombreVacuna;
    private String nombreVeterinario;
    private String NombreMascota;

    public citaVacunaDTo(Date fecha, Time hora, String nombreVacuna, String nombreVeterinario, String nombreMascota) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombreVacuna = nombreVacuna;
        this.nombreVeterinario = nombreVeterinario;
        NombreMascota = nombreMascota;
    }

    public citaVacunaDTo() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        NombreMascota = nombreMascota;
    }
}
