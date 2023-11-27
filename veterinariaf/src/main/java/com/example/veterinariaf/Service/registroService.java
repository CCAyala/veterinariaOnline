package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.registroDTo;

import java.util.List;
import java.util.Objects;

public interface registroService {

    public List<registro> listarRegistro();

    public List<registroDTo> ListaConcodigoMascota();

    public registro crearRegistro(registro diagnosticos);

    public List<registro>findBymascotascod_masco(int cod_mascota);

    public registro buscarRegistros(int codRegistro);

    public registroDTo buscarRegistross(int codregistro);

    public List<Object[]> buscarPorNombre(String nombre);

    public registro modificarRegistro(int codRegistro, registro registros);


    public registro eliminarRegistro(int codRegistro);
}
