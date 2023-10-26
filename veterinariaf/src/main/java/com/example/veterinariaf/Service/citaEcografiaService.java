package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.citaEcografiaDTo;
import com.example.veterinariaf.entity.cita_ecografia;

import java.util.List;

public interface citaEcografiaService {

    public List<citaEcografiaDTo> listarCitaEcogra();

    public cita_ecografia crearCitaEcogra( cita_ecografia citaEcografia,String nombre, String nombreE, String nombreV);

    public cita_ecografia modificarCitaEcogra(int idEcogra, cita_ecografia citaEcografia);

    public  cita_ecografia buscarCita(int idEcografia);
}
