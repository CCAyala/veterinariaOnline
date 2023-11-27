package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.servicios;
import com.example.veterinariaf.entity.vacunas;

import java.util.List;

public interface servicioService {

    public List<servicios> listarServicios();

    public servicios crearServicio(servicios servicio);

    public  servicios modificarServicio(int idServicio, servicios servicio);

    public servicios buscarServicio(int idServicio);

    public  servicios buscarXnombre(String nombre);
}
