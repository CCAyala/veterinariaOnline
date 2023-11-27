package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.veterinario;

import java.util.List;

public interface veterinarioService {


    public List<veterinario> ListarVeterirnarios();

    public veterinario crearVeterinario(veterinario veterinari);

    public veterinario findByVeterinarioXcedula (int cedula);

    public veterinario buscarPorNombre (String nombre);

    public veterinario modificarVeterinario(veterinario veterinari, int cedula);

    public void eliminarVeterinario(int cedula );


}
