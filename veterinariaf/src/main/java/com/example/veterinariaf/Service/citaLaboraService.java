package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.citaLaboratotioDto;
import com.example.veterinariaf.entity.cita_laboratorio;

import java.util.List;

public interface citaLaboraService {

    public List<citaLaboratotioDto> listarCitas();

    public cita_laboratorio crearCitaLabora(cita_laboratorio citaLaboratorios, String nombre, String nombreP, String nombreV);

    public cita_laboratorio modificarCitaLabora(int idCitaLabora, cita_laboratorio citaLaboratorio);
}
