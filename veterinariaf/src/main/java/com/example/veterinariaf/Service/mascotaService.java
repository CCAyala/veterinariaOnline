package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.mascotaDTO;

import java.util.List;

public interface mascotaService {

    public List<mascota> listarMascotas();

    public List<mascotaDTO>listarMascotaConnombre();

    public mascota crearMascota( mascota mascotas);

    public mascota modificarMascota(mascota mascotas);

    public mascota buscarMascota(int codmasco);

    public void eliminarMascota(int codmasco);

    public mascota buscarXnombre(String nombre);
}

