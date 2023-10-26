package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "diagnostico")
@JsonIgnoreProperties({"registro"})
public class diagnostico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int nDiagnostico;
    @Column(nullable = false,length = 250)
    private String descripccion;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "codAnalisis")
    @JsonIgnore
    private analisis analisis;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "planMejoramiento",
            joinColumns = @JoinColumn(name = "id_Diagnostico", referencedColumnName = "nDiagnostico"),
            inverseJoinColumns = @JoinColumn(name = "id_medicamento",referencedColumnName = "idMedicamento")

    )
    private List<medicamentos> ListMedicamentos;




    public diagnostico(int nDiagnostico, String descripccion, String estado) {
        this.nDiagnostico = nDiagnostico;
        this.descripccion = descripccion;
        this.estado = estado;
    }

    public diagnostico() {
    }

    public int getnDiagnostico() {
        return nDiagnostico;
    }

    public void setnDiagnostico(int nDiagnostico) {
        this.nDiagnostico = nDiagnostico;
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

  public com.example.veterinariaf.entity.analisis getAnalisis() {
    return analisis;
  }

  public void setAnalisis(com.example.veterinariaf.entity.analisis analisis) {
    this.analisis = analisis;
  }
}
