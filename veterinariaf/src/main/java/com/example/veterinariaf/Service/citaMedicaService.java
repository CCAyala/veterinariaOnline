package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.citaMedicaDTo;
import com.example.veterinariaf.entity.cita_medica;

import java.util.List;

public interface citaMedicaService {


  public List<citaMedicaDTo>listarCitaMedica();

  public cita_medica crearCitaMedica(cita_medica citaMedica,String nombre, String nombreCo, String nombreV);

  public cita_medica modificaCita(int idCitaMedica, cita_medica citaMedica);
}
