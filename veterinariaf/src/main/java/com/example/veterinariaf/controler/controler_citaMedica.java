package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.citaMedicaIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.citaVacunaIMPL;
import com.example.veterinariaf.entity.citaMedicaDTo;
import com.example.veterinariaf.entity.citaVacunaDTo;
import com.example.veterinariaf.entity.cita_medica;
import com.example.veterinariaf.entity.cita_vacunas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citaMedica")
@CrossOrigin(origins = {"*"})
public class controler_citaMedica {



  private final citaMedicaIMPL impl;

  @Autowired

  public controler_citaMedica(citaMedicaIMPL impl){
    this.impl=impl;
  }


  @GetMapping("listarCitaMedica")
  public ResponseEntity<List<citaMedicaDTo>> listarCitaMedica(){
    List<citaMedicaDTo> listarCitas=this.impl.listarCitaMedica();
    return ResponseEntity.ok(listarCitas);
  }


  @PostMapping("crearCitaMedica/{nombre}/{nombreCo}/{nombreV}")
  public ResponseEntity<String>crearCitaMedica(
    @RequestBody cita_medica citaMedica,
    @PathVariable String nombre,
    @PathVariable String nombreCo,
    @PathVariable String nombreV){

    cita_medica citaNueva=this.impl.crearCitaMedica(citaMedica,nombre,nombreCo,nombreV);

    if (citaNueva!=null){
      return  ResponseEntity.status(HttpStatus.CREATED).body(" su cita medica a sido creada");
    }else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear");
    }

  }
}
