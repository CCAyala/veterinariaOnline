package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.analisis;
import com.example.veterinariaf.entity.analisisDTO;

import java.util.List;

public interface analisisService {


    public List<analisisDTO> listarAnalisis();

    public List<analisis> listaAnalisis();

    public analisis crearAnalisis(analisis analisa);

    public analisis modificarAnalisis(analisis analisa, int codAnalisis);

    public List<analisis> buscarAnalisisPorRegistro(int codregistro);

    public  analisis buscarAnalisis(int codAnalisis);

    public List<Object[]> buscarAnalisisXmasco(String nombre);


}
