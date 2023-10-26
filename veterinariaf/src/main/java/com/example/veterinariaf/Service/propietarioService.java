package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.propietario;

import java.util.List;

public interface propietarioService {

    public List<propietario> listarPropietarios();

    public propietario crearPropietario(propietario propietario);

    public propietario buscarPropietario(int id);

    public propietario findByPropietarioXcedula(int cedula);

    public propietario modificarPropietario(propietario propietario, int cedula);

    public void eliminarPropietario(int id);

}
