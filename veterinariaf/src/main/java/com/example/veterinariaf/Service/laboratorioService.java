package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.Laboratorio;

import java.util.List;

public interface laboratorioService {


    public List<Laboratorio> listarLaboratorio();

    public  Laboratorio crearLaboratorio(Laboratorio laboratorio);

    public Laboratorio buscarLabiratorio(int id_labora);
     public Laboratorio buscarXnombre(String nombre);

     public Laboratorio modificarLaboratorio(int id_labora, Laboratorio laboratorio);
}
