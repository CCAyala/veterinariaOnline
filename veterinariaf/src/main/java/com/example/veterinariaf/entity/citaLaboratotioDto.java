package com.example.veterinariaf.entity;

import java.sql.Date;
import java.sql.Time;

public class citaLaboratotioDto {



    private Date fecha;
    private Time hora;
    private String nombrePrueba;
    private String nombreVeterinario;
    private String NombreMascota;


    public citaLaboratotioDto(Date fecha, Time hora, String nombrePrueba, String nombreVeterinario, String nombreMascota) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombrePrueba = nombrePrueba;
        this.nombreVeterinario = nombreVeterinario;
        NombreMascota = nombreMascota;
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

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
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
