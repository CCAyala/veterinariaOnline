package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Entity
@Table(name = "ecografia")
public class ecografia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idEcogra;
    @Column(nullable = false,length = 50)
    private String nombre;

    @Column(nullable = false, length = 250)
    private String tipoEcografia;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "cita_ecografia",
            joinColumns = @JoinColumn(name = "idEcografia", referencedColumnName = "idEcogra"),
            inverseJoinColumns = @JoinColumn(name = "codMasco",referencedColumnName = "codmasco")

    )
    private List<mascota> mascotaList;


    public ecografia(int idEcogra, String nombre, String tipoEcografia) {
        this.idEcogra = idEcogra;
        this.nombre = nombre;
        this.tipoEcografia = tipoEcografia;
    }

    public ecografia() {
    }

    public int getIdEcogra() {
        return idEcogra;
    }

    public void setIdEcogra(int idEcogra) {
        this.idEcogra = idEcogra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoEcografia() {
        return tipoEcografia;
    }

    public void setTipoEcografia(String tipoEcografia) {
        this.tipoEcografia = tipoEcografia;
    }

    public List<mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }
}
