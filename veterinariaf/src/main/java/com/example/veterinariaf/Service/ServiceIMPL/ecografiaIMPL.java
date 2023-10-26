package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.ecografiaService;
import com.example.veterinariaf.entity.consultaMedica;
import com.example.veterinariaf.entity.ecografia;
import com.example.veterinariaf.repositorio.ecografiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ecografiaIMPL implements ecografiaService {

    private final ecografiaRepo repo;

    @Autowired

    public ecografiaIMPL(ecografiaRepo repo){
        this.repo=repo;
    }

    @Override
    public List<ecografia> listarecografia() {
       return(List<ecografia>) this.repo.findAll();
    }

    @Override
    public ecografia crearEcografia(ecografia ecografias) {
        return this.repo.save(ecografias);
    }

    @Override
    public ecografia buscarXnombre(String nombre) {
    ecografia buscarEco=this.repo.buscarXnombre(nombre);

        if (buscarEco!=null){
            return buscarEco;
        }
        else {
            throw new RuntimeException("ecografia no encontrada");
        }
    }

  @Override
  public ecografia busarecografia(int id_ecografia) {
    return this.repo.findById(id_ecografia).get();
  }

  @Override
  public ecografia modificarEcografia(int idEcogra, ecografia ecografias) {
    ecografia buscarEcografia=this.busarecografia(idEcogra);
    if (buscarEcografia!=null){
      ecografia  consultaExistente= buscarEcografia;
      consultaExistente.setNombre(ecografias.getNombre());
      consultaExistente.setTipoEcografia(ecografias.getTipoEcografia());

      ecografia ecografiaModificada=this.repo.save(consultaExistente);
      if (ecografiaModificada!=null){
        return ecografiaModificada;
      }else {
        throw new RuntimeException("no se modifico la ecografia");
      }
    }else {
      throw new RuntimeException("ecografia no encontrada");
    }

  }



}
