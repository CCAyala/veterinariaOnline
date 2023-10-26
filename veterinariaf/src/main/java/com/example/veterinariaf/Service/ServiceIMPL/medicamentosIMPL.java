package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.medicamentosService;
import com.example.veterinariaf.entity.medicamentos;
import com.example.veterinariaf.repositorio.medicamentosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class medicamentosIMPL implements medicamentosService {

    private final medicamentosRepo repo;

    @Autowired
    public  medicamentosIMPL(medicamentosRepo repo){
        this.repo=repo;
    }
    @Override
    public List<medicamentos> listarMedicamentos() {
        return (List<medicamentos>) this.repo.findAll();
    }

    @Override
    public medicamentos crearMedicamento(medicamentos medicamento) {
        return this.repo.save(medicamento);
    }

    @Override
    public medicamentos modificarmedicamento(int codMedi, medicamentos medicamento) {
        Optional<medicamentos> buscarMedicamento=this.repo.findById(codMedi);

        if (buscarMedicamento.isPresent()){
            medicamentos medicamentosexistente=buscarMedicamento.get();
            medicamentosexistente.setNombre(medicamento.getNombre());
            medicamentosexistente.setTipoMedicamento(medicamento.getTipoMedicamento());

            medicamentos medicamentoModificado=this.repo.save(medicamentosexistente);

            if (medicamentoModificado!=null){
                System.out.println("modificacion exitosa");
            }
        }else {
            System.out.println("medicamento no modificado");
        }
        return null;
    }

    @Override
    public medicamentos buscarMendicamento(int codMedi) {
        return this.repo.findById(codMedi).get();
    }

  @Override
  public medicamentos buscarXnombre(String nombreMedi) {
    return this.repo.buscarXnombre(nombreMedi);
  }
}
