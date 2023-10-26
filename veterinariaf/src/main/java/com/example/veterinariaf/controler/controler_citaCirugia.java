package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.citaCirugiaIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.citaMedicaIMPL;
import com.example.veterinariaf.entity.citaCirugiaDTo;
import com.example.veterinariaf.entity.citaMedicaDTo;
import com.example.veterinariaf.entity.cita_cirugia;
import com.example.veterinariaf.entity.cita_medica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citaCirugia")
@CrossOrigin(origins = {"*"})
public class controler_citaCirugia {


  private final citaCirugiaIMPL impl;

  @Autowired

  public controler_citaCirugia(citaCirugiaIMPL impl){
    this.impl=impl;
  }


  @GetMapping("listarCitaCirugia")
  public ResponseEntity<List<citaCirugiaDTo>> listarCitaMedica(){
    List<citaCirugiaDTo> listarCitas=this.impl.listarCitaCirugia();
    return ResponseEntity.ok(listarCitas);
  }


  @PostMapping("crearCitaCirugia/{nombre}/{nombreC}/{nombreV}")
  public ResponseEntity<String>crearCitaCirugia(
    @RequestBody cita_cirugia citaCirugia,
    @PathVariable String nombre,
    @PathVariable String nombreC,
    @PathVariable String nombreV){

    cita_cirugia citaNueva=this.impl.crearCita(citaCirugia,nombre,nombreC,nombreV);

    if (citaNueva!=null){
      return  ResponseEntity.status(HttpStatus.CREATED).body(" su cita a Cirugia a sido creada");
    }else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear");
    }

  }
}
