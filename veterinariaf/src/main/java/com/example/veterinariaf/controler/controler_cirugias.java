package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.cirugiasIMPL;
import com.example.veterinariaf.entity.cirugias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cirugias")
@CrossOrigin(origins = {"*"})
public class controler_cirugias {

  private  final cirugiasIMPL impl;

  @Autowired
  public controler_cirugias(cirugiasIMPL impl){
    this.impl=impl;
  }

  @GetMapping("listarCirugias")
  public ResponseEntity<List<cirugias>>listarCirugias(){
   List <cirugias> listarCirugia=this.impl.listarCirugias();
    return ResponseEntity.ok(listarCirugia);
  }

  @PostMapping("crearCirugia")
  public ResponseEntity<String>crearCirugia(@RequestBody cirugias cirugia){

    cirugias nuevaCirugia=this.impl.crearCirugia(cirugia);

    if (nuevaCirugia!=null){
      return ResponseEntity.status(HttpStatus.CREATED).body("cirugia creada");
    }else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cirugia no creada");
    }
  }

  @PutMapping("modificarCiruga/{idCirugia}")
  public ResponseEntity<String>modificarCirugia(@PathVariable int idCirugia, @RequestBody cirugias cirugia){

    cirugias buscarCirugia=this.impl.buscarCirugia(idCirugia);

    if (buscarCirugia!=null){

      cirugias modificarCirugia=this.impl.modificarCirugia(idCirugia,cirugia);

      if (modificarCirugia!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");
      }else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se modifico nada");
      }


    }else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro cirugia");
    }


  }
}
