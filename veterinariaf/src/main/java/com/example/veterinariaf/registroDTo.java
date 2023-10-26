package com.example.veterinariaf;

import jakarta.persistence.Column;

import java.sql.Date;

public class registroDTo {


    private int codRegistro;

    private String estadoCardioMuscular;
    private String estadoDigestivo;
    private String estadoRespiratorio;
    private  String  estadoGenitario;
    private String estadoLocomocion;
    private String estadoModuloslinfaticos;
    private String estadomMusculoEsqueletico;
    private String estadoOjos;
    private String estadoPielyanex;
    private String estadoSistemaNervioso;
    private Date fechaIng;

    private String nombreMasco;


    public registroDTo(int codRegistro,String estadoCardioMuscular, String estadoDigestivo, String estadoRespiratorio, String estadoGenitario, String estadoLocomocion, String estadoModuloslinfaticos, String estadomMusculoEsqueletico, String estadoOjos, String estadoPielyanex, String estadoSistemaNervioso, Date fechaIng,String nombreMasco) {
        this.codRegistro = codRegistro;
        this.estadoCardioMuscular = estadoCardioMuscular;
        this.estadoDigestivo = estadoDigestivo;
        this.estadoRespiratorio = estadoRespiratorio;
        this.estadoGenitario = estadoGenitario;
        this.estadoLocomocion = estadoLocomocion;
        this.estadoModuloslinfaticos = estadoModuloslinfaticos;
        this.estadomMusculoEsqueletico = estadomMusculoEsqueletico;
        this.estadoOjos = estadoOjos;
        this.estadoPielyanex = estadoPielyanex;
        this.estadoSistemaNervioso = estadoSistemaNervioso;
        this.fechaIng = fechaIng;

        this.nombreMasco=nombreMasco;
    }


    public registroDTo() {
    }

    public int getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(int codRegistro) {
        this.codRegistro = codRegistro;
    }

    public String getNombreMasco() {
        return nombreMasco;
    }

    public void setNombreMasco(String nombreMasco) {
        this.nombreMasco = nombreMasco;
    }

    public String getEstadoCardioMuscular() {
        return estadoCardioMuscular;
    }

    public void setEstadoCardioMuscular(String estadoCardioMuscular) {
        this.estadoCardioMuscular = estadoCardioMuscular;
    }

    public String getEstadoDigestivo() {
        return estadoDigestivo;
    }

    public void setEstadoDigestivo(String estadoDigestivo) {
        this.estadoDigestivo = estadoDigestivo;
    }

    public String getEstadoRespiratorio() {
        return estadoRespiratorio;
    }

    public void setEstadoRespiratorio(String estadoRespiratorio) {
        this.estadoRespiratorio = estadoRespiratorio;
    }

    public String getEstadoGenitario() {
        return estadoGenitario;
    }

    public void setEstadoGenitario(String estadoGenitario) {
        this.estadoGenitario = estadoGenitario;
    }

    public String getEstadoLocomocion() {
        return estadoLocomocion;
    }

    public void setEstadoLocomocion(String estadoLocomocion) {
        this.estadoLocomocion = estadoLocomocion;
    }

    public String getEstadoModuloslinfaticos() {
        return estadoModuloslinfaticos;
    }

    public void setEstadoModuloslinfaticos(String estadoModuloslinfaticos) {
        this.estadoModuloslinfaticos = estadoModuloslinfaticos;
    }

    public String getEstadomMusculoEsqueletico() {
        return estadomMusculoEsqueletico;
    }

    public void setEstadomMusculoEsqueletico(String estadomMusculoEsqueletico) {
        this.estadomMusculoEsqueletico = estadomMusculoEsqueletico;
    }

    public String getEstadoOjos() {
        return estadoOjos;
    }

    public void setEstadoOjos(String estadoOjos) {
        this.estadoOjos = estadoOjos;
    }

    public String getEstadoPielyanex() {
        return estadoPielyanex;
    }

    public void setEstadoPielyanex(String estadoPielyanex) {
        this.estadoPielyanex = estadoPielyanex;
    }

    public String getEstadoSistemaNervioso() {
        return estadoSistemaNervioso;
    }

    public void setEstadoSistemaNervioso(String estadoSistemaNervioso) {
        this.estadoSistemaNervioso = estadoSistemaNervioso;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }


}
