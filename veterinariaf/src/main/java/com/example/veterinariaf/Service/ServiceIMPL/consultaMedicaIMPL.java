package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.consultaMedicaService;
import com.example.veterinariaf.entity.cirugias;
import com.example.veterinariaf.entity.consultaMedica;
import com.example.veterinariaf.repositorio.consultaMedicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class consultaMedicaIMPL implements consultaMedicaService {


  private final consultaMedicaRepo repo;

  @Autowired
  public consultaMedicaIMPL(consultaMedicaRepo repo){
    this.repo=repo;
  }
  @Override
  public List<consultaMedica> listarConsultas() {
    return (List<consultaMedica>) this.repo.findAll();
  }

  @Override
  public consultaMedica crearConsultaMedica(consultaMedica consultaMedicas) {
    return this.repo.save(consultaMedicas);
  }

  @Override
  public consultaMedica buscarXnombre(String nombre) {
    consultaMedica buscarConsulta=this.repo.buscarXnombre(nombre);
    if (buscarConsulta!=null){
      return buscarConsulta;
    }else {
      throw  new RuntimeException("consulta no encontrada");
    }
  }

  @Override
  public consultaMedica buscarConsulta(int idConsulta) {
    return this.repo.findById(idConsulta).get();
  }

  @Override
  public consultaMedica modificarConsulta(int idConsulta, consultaMedica consultaMedicas) {
    consultaMedica buscarConsulta=this.buscarConsulta(idConsulta);
    if (buscarConsulta!=null){
      consultaMedica  consultaExistente= buscarConsulta;
      consultaExistente.setNombre(consultaMedicas.getNombre());
      consultaExistente.setTipoCita(consultaMedicas.getTipoCita());

      consultaMedica cirugiaModificada=this.repo.save(consultaExistente);

      if (cirugiaModificada!=null){
        return cirugiaModificada;
      }else {
        throw new RuntimeException("no se modifico la cirugia");
      }
    }else {
      throw new RuntimeException("cirugia no encontrada");
    }

  }
}
