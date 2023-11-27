package com.example.veterinariaf.entity;

import java.sql.Date;

public class mascotaDTO {

    private int codmasco;

    private String nombre;

    private String color;

    private String especie;

    private String raza;

    private  String nombre_completo;
    private Date fechanaci;


    public mascotaDTO(int codmasco, String nombre, String nombre_completo, String color, String especie,  Date fechanaci,String raza) {
        this.codmasco = codmasco;
        this.nombre = nombre;
        this.color = color;
        this.especie = especie;
        this.raza = raza;
        this.nombre_completo = nombre_completo;
        this.fechanaci = fechanaci;
    }

    public mascotaDTO() {
    }

    public int getCodmasco() {
        return codmasco;
    }

    public void setCodmasco(int codmasco) {
        this.codmasco = codmasco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public Date getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(Date fechanaci) {
        this.fechanaci = fechanaci;
    }
}


