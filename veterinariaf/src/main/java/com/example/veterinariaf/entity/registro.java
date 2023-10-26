package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "registro")
@JsonIgnoreProperties({"analisis1", "diagnosticoList"})
public class registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codRegistro;
    @Column(nullable = false,length = 200)
    private String estadoCardioMuscular;
    @Column(nullable = false,length = 200)
    private String estadoDigestivo;
    @Column(nullable = false,length = 200)
    private String estadoRespiratorio;
    @Column(nullable = false,length = 200)
    private  String  estadoGenitario;
    @Column(nullable = false,length = 200)
    private String estadoLocomocion;
    @Column(nullable = false,length = 200)
    private String estadoModuloslinfaticos;
    @Column(nullable = false,length = 200)
    private String estadomMusculoEsqueletico;
    @Column(nullable = false,length = 200)
    private String estadoOjos;
    @Column(nullable = false,length = 200)
    private String estadoPielyanex;
    @Column(nullable = false,length = 200)
    private String estadoSistemaNervioso;
    private Date fechaIng;


    @ManyToOne
    @JoinColumn(name = "codmascota")
    @JsonIgnore
    private mascota mascotas;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "registro",cascade = CascadeType.ALL)
    @JsonManagedReference("registro-analisis")
    private List <analisis> analisis1;



    public registro(int codRegistro, String estadoCardioMuscular, String estadoDigestivo, String estadoRespiratorio, String estadoGenitario, String estadoLocomocion, String estadoModuloslinfaticos, String estadomMusculoEsqueletico, String estadoOjos, String estadoPielyanex, String estadoSistemaNervioso, Date fechaIng, mascota mascotas) {
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
        this.mascotas = mascotas;
    }

    public registro() {
    }

    public int getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(int codRegistro) {
        this.codRegistro = codRegistro;
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




    public mascota getMascotas() {
        return mascotas;
    }

    public void setMascotas(mascota mascotas) {
        this.mascotas = mascotas;
    }

    public List<analisis> getAnalisis1() {
        return analisis1;
    }

    public void setAnalisis1(List<analisis> analisis1) {
        this.analisis1 = analisis1;
    }



}
