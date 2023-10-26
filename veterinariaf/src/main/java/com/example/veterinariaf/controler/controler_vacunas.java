package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.vacunasIMPL;
import com.example.veterinariaf.entity.ecografia;
import com.example.veterinariaf.entity.vacunas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vacunas")
@CrossOrigin(origins = {"*"})
public class controler_vacunas {

    private final vacunasIMPL impl;

    @Autowired

    public controler_vacunas(vacunasIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarVacunas")
    public ResponseEntity<List<vacunas>>listarVacunas(){

       List <vacunas> listarVacuna=this.impl.listarVacunas();

        return ResponseEntity.ok(listarVacuna);
    }

    @PostMapping("crearVacuna")
    public ResponseEntity<String>crearVacuna(@RequestBody vacunas vacuna){
        vacunas nuevaVacuna=this.impl.crearVacuna(vacuna);

        if (nuevaVacuna!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("vacuna creada con exito");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("vacuna no creada");
        }

    }

  @PutMapping("modificarVacuna/{idVacuna}")
  public ResponseEntity<String>modificarVacuna(@PathVariable int idVacuna, @RequestBody vacunas vacuna){

    vacunas buscarVacuna=this.impl.buscaVacuna(idVacuna);

    if (buscarVacuna!=null){

      vacunas modificarVacuna=this.impl.modificarVacuna(idVacuna,vacuna);

      if (modificarVacuna!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");
      }else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se modifico nada");
      }


    }else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro Vacuna");
    }


  }
}
