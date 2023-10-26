package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.vacunas;

import java.util.List;

public interface vacunasService {


    public List<vacunas>listarVacunas();

    public vacunas crearVacuna(vacunas vacunas);

    public  vacunas modificarVacuna(int idVacuna, vacunas vacuna);

    public vacunas buscaVacuna(int idVacuna);
}
