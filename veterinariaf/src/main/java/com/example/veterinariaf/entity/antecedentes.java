package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "antecedentes")
public class antecedentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 250)
    private String enfermedadesante;
    @Column(nullable = false,length = 250)
    private String Alergias;
    @Column(nullable = false,length = 250)
    private String  estadocastracion;
    @Column(nullable = false,length = 250)
    private String habitad;
    @Column(nullable = false)
    private Date fechultidesparacitacion;
    @Column(nullable = false,length = 250)
    private String cirugiasanter;
    @Column(nullable = false,length = 250)
    private String estadoreproductivo;


    @OneToOne
    @JoinColumn(name = "cod_mascota")
    @JsonIgnore
    private mascota mascota;

    public antecedentes(int id, String enfermedadesante, String alergias, String estadocastracion, String habitad, Date fechultidesparacitacion, String cirugiasanter, String estadoreproductivo) {
        this.id = id;
        this.enfermedadesante = enfermedadesante;
        Alergias = alergias;
        this.estadocastracion = estadocastracion;
        this.habitad = habitad;
        this.fechultidesparacitacion = fechultidesparacitacion;
        this.cirugiasanter = cirugiasanter;
        this.estadoreproductivo = estadoreproductivo;
    }

    public antecedentes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnfermedadesante() {
        return enfermedadesante;
    }

    public void setEnfermedadesante(String enfermedadesante) {
        this.enfermedadesante = enfermedadesante;
    }

    public String getAlergias() {
        return Alergias;
    }

    public void setAlergias(String alergias) {
        Alergias = alergias;
    }

    public String getEstadocastracion() {
        return estadocastracion;
    }

    public void setEstadocastracion(String estadocastracion) {
        this.estadocastracion = estadocastracion;
    }

    public String getHabitad() {
        return habitad;
    }

    public void setHabitad(String habitad) {
        this.habitad = habitad;
    }

    public Date getFechultidesparacitacion() {
        return fechultidesparacitacion;
    }

    public void setFechultidesparacitacion(Date fechultidesparacitacion) {
        this.fechultidesparacitacion = fechultidesparacitacion;
    }

    public String getCirugiasanter() {
        return cirugiasanter;
    }

    public void setCirugiasanter(String cirugiasanter) {
        this.cirugiasanter = cirugiasanter;
    }

    public String getEstadoreproductivo() {
        return estadoreproductivo;
    }

    public void setEstadoreproductivo(String estadoreproductivo) {
        this.estadoreproductivo = estadoreproductivo;
    }

    public com.example.veterinariaf.entity.mascota getMascota() {
        return mascota;
    }

    public void setMascota(com.example.veterinariaf.entity.mascota mascota) {
        this.mascota = mascota;
    }


}
