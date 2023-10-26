package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.ecografia;

import java.util.List;

public interface ecografiaService {

    public List<ecografia> listarecografia();

    public  ecografia crearEcografia(ecografia ecografias);

    public ecografia buscarXnombre(String nombre);

    public ecografia busarecografia(int id_ecografia);

    public ecografia modificarEcografia(int idEcogra, ecografia ecografias);
}
