package com.example.veterinariaf.entity;

import java.sql.Date;
import java.sql.Time;

public class citaServicioDTO {



    private Date fecha;
    private Time hora;
    private String nombreServicio;
    private String nombreVeterinario;
    private String NombreMascota;

    public citaServicioDTO(Date fecha, Time hora, String nombreServicio, String nombreVeterinario, String nombreMascota) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombreServicio = nombreServicio;
        this.nombreVeterinario = nombreVeterinario;
        NombreMascota = nombreMascota;
    }

    public citaServicioDTO() {
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

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
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
