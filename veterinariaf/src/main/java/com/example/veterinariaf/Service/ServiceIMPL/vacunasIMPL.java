package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.vacunasService;
import com.example.veterinariaf.entity.ecografia;
import com.example.veterinariaf.entity.vacunas;
import com.example.veterinariaf.repositorio.vacunasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class vacunasIMPL implements vacunasService {

    private final vacunasRepo repo;

    @Autowired

    public vacunasIMPL(vacunasRepo repo){
        this.repo=repo;
    }
    @Override
    public List<vacunas> listarVacunas() {
        return (List<vacunas>) this.repo.findAll();
    }

    @Override
    public vacunas crearVacuna(vacunas vacunas) {
        return this.repo.save(vacunas);
    }

    @Override
    public vacunas modificarVacuna(int idVacuna, vacunas vacuna) {

      vacunas buscarVacuna=this.buscaVacuna(idVacuna);
      if (buscarVacuna!=null){
        vacunas  consultaExistente= buscarVacuna;
        consultaExistente.setNombre(vacuna.getNombre());
        consultaExistente.setTipoVacuna(vacuna.getTipoVacuna());

        vacunas vacunaModificada=this.repo.save(consultaExistente);
        if (vacunaModificada!=null){
          return vacunaModificada;
        }else {
          throw new RuntimeException("no se modifico la ecografia");
        }
      }else {
        throw new RuntimeException("ecografia no encontrada");
      }

    }



  @Override
  public vacunas buscaVacuna(int idVacuna) {
    return this.repo.findById(idVacuna).get();
  }
}
