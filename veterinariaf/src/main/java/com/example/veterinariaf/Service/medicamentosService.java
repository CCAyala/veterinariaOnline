package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.medicamentos;

import java.util.List;

public interface medicamentosService {


    public List<medicamentos> listarMedicamentos();

    public medicamentos crearMedicamento (medicamentos medicamento);

    public medicamentos modificarmedicamento(int codMedi, medicamentos medicamento);

    public medicamentos buscarMendicamento(int codMedi);

    public medicamentos buscarXnombre(String nombreMedi);
}
