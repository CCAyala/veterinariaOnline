package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.citaCirugiaDTo;
import com.example.veterinariaf.entity.cita_cirugia;

import java.util.List;

public interface citaCirugiaService {

  public List<citaCirugiaDTo>listarCitaCirugia();

  public cita_cirugia crearCita(cita_cirugia citaCirugia,String nombre, String nombreC, String nombreV);

  public cita_cirugia modificarCita(int idCitaCirugia, cita_cirugia citaCirugia);

  public cita_cirugia buscarCitaCirugia(int idCitaCirugia);
}
