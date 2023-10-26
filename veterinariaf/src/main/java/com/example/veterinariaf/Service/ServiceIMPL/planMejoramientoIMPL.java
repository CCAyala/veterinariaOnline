package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.planMejoramientoService;
import com.example.veterinariaf.entity.*;
import com.example.veterinariaf.repositorio.diagnosticoRepo;
import com.example.veterinariaf.repositorio.medicamentosRepo;
import com.example.veterinariaf.repositorio.planMejoramientoRepo;
import com.example.veterinariaf.repositorio.veterinarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class planMejoramientoIMPL implements planMejoramientoService {

  private final planMejoramientoRepo repo;
  private  final veterinarioRepo repoVet;

  private final medicamentosRepo repoMedi;

  private final diagnosticoRepo repoDiag;
  @Autowired
  public planMejoramientoIMPL(diagnosticoRepo repoDiag,medicamentosRepo repoMedi,veterinarioRepo repoVet,planMejoramientoRepo repo){
    this.repo=repo;
    this.repoDiag=repoDiag;
    this.repoMedi=repoMedi;
    this.repoVet=repoVet;
  }
  @Override
  public List<planMejoramientoDTO> listarPLanMejoramiento() {
    List<Object[]> resultado= this.repo.listarPLanMejoramiento();
    List<planMejoramientoDTO> planMejoramientoDTOS=new ArrayList<>();

    for (Object[] resul: resultado){
      planMejoramientoDTOS.add(new planMejoramientoDTO(
        (Date) resul[0],
        (String) resul[1],
        (int) resul[2],
        (String) resul[3],
        (String) resul[4],
        (String) resul[5]
      ));

    }
    return planMejoramientoDTOS;
  }
  //Hola sr monitorit
  @Override
  public planMejoramiento crearPlanMejoramiento(planMejoramiento planMejoramientos,int nDiagnostico, String nombreVete, String nombreMedi) {
    try {

      Optional<diagnostico> buscarDiagnotico=Optional.ofNullable(repoDiag.findById(nDiagnostico).get());
      if (!buscarDiagnotico.isPresent()){
        throw new RuntimeException("el codigo de Diagnotico no puede ser nullo" + buscarDiagnotico);
      }
      Optional<medicamentos> buscarmedicamento = Optional.ofNullable(repoMedi.buscarXnombre(nombreMedi));
      if (!buscarmedicamento.isPresent()){
        medicamentos medicamento = buscarmedicamento.get();
        throw new RuntimeException("El nombre del medicamento no puede ser nulo" + nombreMedi + medicamento);
      }

      Optional<veterinario> buscarVete=Optional.ofNullable(repoVet.buscarPorNombre(nombreVete));
      if (!buscarVete.isPresent()){
        throw new RuntimeException("el nombre del veterinario no puede ser nulo" + buscarVete);
      }




      diagnostico diagnostico=buscarDiagnotico.get();
      veterinario veterinario=buscarVete.get();
      medicamentos medicamentos=buscarmedicamento.get();

      planMejoramientos.setDiagnostico(diagnostico);
      planMejoramientos.setVeterinario(veterinario);
      planMejoramientos.setMedicamentos(medicamentos);

      planMejoramiento nuevoPLan= repo.save(planMejoramientos);

      if (nuevoPLan != null){
        return nuevoPLan;
      }else {
        throw new RuntimeException("plan de mejoramiento no guardado ");
      }

    }catch (Exception e){
      System.out.println("error "+e.getMessage());
      e.printStackTrace();
      return null;
    }


  }
}
