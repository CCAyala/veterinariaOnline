package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.diagnosticoIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.medicamentosIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.planMejoramientoIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.veterinarioIMPL;
import com.example.veterinariaf.entity.planMejoramiento;
import com.example.veterinariaf.entity.planMejoramientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planMejoramiento")
@CrossOrigin(origins = {"*"})
public class controler_planMejoramiento {

  private final planMejoramientoIMPL impl;

  private final veterinarioIMPL implVete;

  private final medicamentosIMPL implMedi;

  private final diagnosticoIMPL implDiag;

  @Autowired

  public controler_planMejoramiento(planMejoramientoIMPL impl,veterinarioIMPL implVete,medicamentosIMPL implMedi,diagnosticoIMPL implDiag){
    this.impl=impl;
    this.implDiag=implDiag;
    this.implMedi=implMedi;
    this.implVete=implVete;
  }

  @GetMapping("listarPLanMejoramiento")
  public ResponseEntity<List<planMejoramientoDTO>> listarPLanMejoramiento(){
    List<planMejoramientoDTO> listarPLan=this.impl.listarPLanMejoramiento();
    return ResponseEntity.ok(listarPLan);
  }


  @PostMapping("crearPLan/{nDiagnostico}/{nombreMedi}/{nombreVete}")
  public ResponseEntity<planMejoramiento>crearPlan(
    @RequestBody planMejoramiento planMejoramientos,
    @PathVariable int nDiagnostico,
    @PathVariable String nombreMedi,
    @PathVariable String nombreVete

  ){
    planMejoramiento nuevoPlan=this.impl.crearPlanMejoramiento(planMejoramientos,nDiagnostico,nombreMedi,nombreVete);

    if (nuevoPlan!=null){
      return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPlan);
    }else {
      throw  new RuntimeException("no se creo nada");
    }

  }
}
