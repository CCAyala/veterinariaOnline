package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "analisis")
@JsonIgnoreProperties({"analisis"})
public class analisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAnalisis;
    @Column(nullable = false,length = 200)
    private String  rectal;
    @Column(nullable = false,length = 200)
    private String  vulvarpropulcal;
    @Column(nullable = false,length = 200)
    private String  actitud;
    @Column(nullable = false,length = 200)
    private String  condicorporal;
    @Column(nullable = false,length = 200)
    private String  estadohidratacion;
    @Column(nullable = false,length = 200)
    private String  oral;
    @Column(nullable = false,length = 200)
    private String  estadomucoso;
    @Column(nullable = false,length = 200)
    private String estadoconjutival;
    @Column(nullable = false,length = 200)
    private String Observaciones;
    @ManyToOne
    @JoinColumn(name = "codregistro")
    @JsonBackReference("analisis-registro")
    private registro registro;


  @OneToMany(fetch = FetchType.LAZY,mappedBy = "analisis",cascade = CascadeType.ALL)
  @
    JsonIgnore
  private List<diagnostico> diagnosticoList;


    public analisis(int codAnalisis, String rectal, String vulvarpropulcal, String actitud, String condicorporal, String estadohidratacion, String oral, String estadomucoso, String estadoconjutival, String observaciones) {
        this.codAnalisis = codAnalisis;
        this.rectal = rectal;
        this.vulvarpropulcal = vulvarpropulcal;
        this.actitud = actitud;
        this.condicorporal = condicorporal;
        this.estadohidratacion = estadohidratacion;
        this.oral = oral;
        this.estadomucoso = estadomucoso;
        this.estadoconjutival = estadoconjutival;
        Observaciones = observaciones;
    }

    public analisis() {
    }

    public int getCodAnalisis() {
        return codAnalisis;
    }

    public void setCodAnalisis(int codAnalisis) {
        this.codAnalisis = codAnalisis;
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
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

  public com.example.veterinariaf.entity.registro getRegistro() {
    return registro;
  }

  public void setRegistro(com.example.veterinariaf.entity.registro registro) {
    this.registro = registro;
  }

  public List<diagnostico> getDiagnosticoList() {
    return diagnosticoList;
  }

  public void setDiagnosticoList(List<diagnostico> diagnosticoList) {
    this.diagnosticoList = diagnosticoList;
  }
}
