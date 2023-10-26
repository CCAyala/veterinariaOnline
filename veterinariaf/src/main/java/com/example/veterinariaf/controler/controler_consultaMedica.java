package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.consultaMedicaIMPL;
import com.example.veterinariaf.entity.cirugias;
import com.example.veterinariaf.entity.consultaMedica;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultaMedica")
@CrossOrigin(origins = {"*"})
public class controler_consultaMedica {


  private final consultaMedicaIMPL impl;

  @Autowired

  public controler_consultaMedica(consultaMedicaIMPL impl){
    this.impl=impl;
  }

  @GetMapping("listarTipoCita")
  public ResponseEntity<List<consultaMedica>>listarTipoCita(){
    List<consultaMedica> listarConsulta=this.impl.listarConsultas();
    return ResponseEntity.ok(listarConsulta);

  }

  @PostMapping("crearConsulta")
  public ResponseEntity<String>crearConsulta(@RequestBody consultaMedica consultaMedicas) {

    consultaMedica nuevaConsulta = this.impl.crearConsultaMedica(consultaMedicas);

    if (nuevaConsulta!=null){
      return ResponseEntity.status(HttpStatus.CREATED).body("consulta creada");
    }else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear");
    }

  }

  @PutMapping("modificarConsultaMedica/{idConsulta}")
  public ResponseEntity<String>modificarCirugia(@PathVariable int idConsulta, @RequestBody consultaMedica consultaMedicas){

    consultaMedica buscarConsulta=this.impl.buscarConsulta(idConsulta);

    if (buscarConsulta!=null){

      consultaMedica modificarConsulta=this.impl.modificarConsulta(idConsulta,consultaMedicas);

      if (modificarConsulta!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");
      }else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se modifico nada");
      }


    }else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro cirugia");
    }


  }

}
