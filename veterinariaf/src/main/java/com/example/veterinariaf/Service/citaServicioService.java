package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.citaServicioDTO;
import com.example.veterinariaf.entity.cita_servicio;

import java.util.List;

public interface citaServicioService {


    public List<citaServicioDTO> listadeCitaSevicio();

    public cita_servicio crearCita( cita_servicio citaServicio, String nombre, String nombreSe, String nombreV);

    public  cita_servicio modificarCita( int idCitaServi, cita_servicio citaServicio);



}
