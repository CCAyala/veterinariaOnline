package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.antecedentes;

import java.util.List;

public interface antecedenteService {



    public List<antecedentes> listarAntecendentes();

    public antecedentes crearAntecedente(antecedentes antecedente);

    public List<antecedentes>findBymascotascod_masco(int cod_mascota);

    public antecedentes modificarAntecedente(int codmasco,antecedentes antecedente);

    public void  eliminarAntecendete(int id);


}
