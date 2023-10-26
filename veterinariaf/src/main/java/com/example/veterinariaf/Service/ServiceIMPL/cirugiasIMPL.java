package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.cirugiasService;
import com.example.veterinariaf.entity.cirugias;
import com.example.veterinariaf.repositorio.cirugiasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class cirugiasIMPL implements cirugiasService {

  private final cirugiasRepo repo;

  @Autowired
   public cirugiasIMPL (cirugiasRepo repo){
    this.repo=repo;
  }
  @Override
  public List<cirugias> listarCirugias() {
    return (List<cirugias>)this.repo.findAll();
  }

  @Override
  public cirugias crearCirugia(cirugias cirugia) {
    return this.repo.save(cirugia);
  }

  @Override
  public cirugias modificarCirugia(int idCirugia, cirugias cirugia) {

    cirugias buscarCirugia=this.buscarCirugia(idCirugia);
    if (buscarCirugia!=null){
      cirugias cirugiaExistente= buscarCirugia;
      cirugiaExistente.setNombre(cirugia.getNombre());
      cirugiaExistente.setTipoCirugia(cirugia.getTipoCirugia());

      cirugias cirugiaModificada=this.repo.save(cirugiaExistente);

      if (cirugiaModificada!=null){
        return cirugiaModificada;
      }else {
        throw new RuntimeException("no se modifico la cirugia");
      }
    }else {
      throw new RuntimeException("cirugia no encontrada");
    }

  }

  @Override
  public cirugias buscarCirugia(int idCirugia) {
    return this.repo.findById(idCirugia).get();
  }
}
