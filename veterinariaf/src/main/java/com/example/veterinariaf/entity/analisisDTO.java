package com.example.veterinariaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class analisisDTO {
    private int codAnalisis;

    private String nombre;
    private String  rectal;
    private String  vulvarpropulcal;
    private String  actitud;
    private String  condicorporal;
    private String  estadohidratacion;
    private String  oral;
    private String  estadomucoso;
    private String estadoconjutival;
    private String observaciones;


    public analisisDTO(int codAnalisis, String nombre, String rectal, String vulvarpropulcal, String actitud, String condicorporal, String estadohidratacion, String oral, String estadomucoso, String estadoconjutival,String observaciones) {
        this.codAnalisis = codAnalisis;
        this.nombre = nombre;
        this.rectal = rectal;
        this.vulvarpropulcal = vulvarpropulcal;
        this.actitud = actitud;
        this.condicorporal = condicorporal;
        this.estadohidratacion = estadohidratacion;
        this.oral = oral;
        this.estadomucoso = estadomucoso;
        this.estadoconjutival = estadoconjutival;
        this.observaciones=observaciones;
    }

    public analisisDTO() {
    }

    public int getCodAnalisis() {
        return codAnalisis;
    }

    public void setCodAnalisis(int codAnalisis) {
        this.codAnalisis = codAnalisis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRectal() {
        return rectal;
    }

    public void setRectal(String rectal) {
        this.rectal = rectal;
    }

    public String getVulvarpropulcal() {
        return vulvarpropulcal;
    }

    public void setVulvarpropulcal(String vulvarpropulcal) {
        this.vulvarpropulcal = vulvarpropulcal;
    }

    public String getActitud() {
        return actitud;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public String getCondicorporal() {
        return condicorporal;
    }

    public void setCondicorporal(String condicorporal) {
        this.condicorporal = condicorporal;
    }

    public String getEstadohidratacion() {
        return estadohidratacion;
    }

    public void setEstadohidratacion(String estadohidratacion) {
        this.estadohidratacion = estadohidratacion;
    }

    public String getOral() {
        return oral;
    }

    public void setOral(String oral) {
        this.oral = oral;
    }

    public String getEstadomucoso() {
        return estadomucoso;
    }

    public void setEstadomucoso(String estadomucoso) {
        this.estadomucoso = estadomucoso;
    }

    public String getEstadoconjutival() {
        return estadoconjutival;
    }

    public void setEstadoconjutival(String estadoconjutival) {
        this.estadoconjutival = estadoconjutival;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
