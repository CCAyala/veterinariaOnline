package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.consultaMedica;

import java.util.List;

public interface consultaMedicaService {


  public List<consultaMedica>listarConsultas();

  public  consultaMedica crearConsultaMedica(consultaMedica consultaMedicas);

  public consultaMedica buscarXnombre(String nombre);

  public consultaMedica buscarConsulta(int idConsulta);
  public consultaMedica modificarConsulta(int idConsulta, consultaMedica consultaMedicas);


}
