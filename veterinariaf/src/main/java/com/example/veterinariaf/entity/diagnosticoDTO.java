package com.example.veterinariaf.entity;

import java.sql.Date;

public class diagnosticoDTO {

    private int nDiagnostico;

    private String nombre;

    private String descripccion;
    private Date fecha;

    private String estado;

    public diagnosticoDTO(int nDiagnostico, String nombre, String descripccion, String estado) {
        this.nDiagnostico = nDiagnostico;
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.estado = estado;
    }

    public int getnDiagnostico() {
        return nDiagnostico;
    }

    public void setnDiagnostico(int nDiagnostico) {
        this.nDiagnostico = nDiagnostico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
