package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.citaVacunaDTo;
import com.example.veterinariaf.entity.cita_vacunas;

import java.util.List;

public interface citaVacunaService {


    public List<citaVacunaDTo>listarCitasVacunas();

    public cita_vacunas crearCitaVacuna(cita_vacunas citaVacuna,String nombre, String nombreVa, String nombreV);

    public cita_vacunas modificarCitaVacuna(int idCitaVacuna, cita_vacunas citaVacuna);
}
