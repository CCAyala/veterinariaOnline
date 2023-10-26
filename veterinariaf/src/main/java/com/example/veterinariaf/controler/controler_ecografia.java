package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.ecografiaIMPL;
import com.example.veterinariaf.entity.cirugias;
import com.example.veterinariaf.entity.ecografia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecografia")
@CrossOrigin(origins = {"*"})
public class controler_ecografia {

    private  final ecografiaIMPL impl;

    @Autowired

    public controler_ecografia(ecografiaIMPL impl){
        this.impl=impl;
    }

    @GetMapping("listarEcografias")
    public ResponseEntity<List<ecografia>>listarEcografias(){
       List <ecografia> listarEco=this.impl.listarecografia();

       return ResponseEntity.ok(listarEco);
    }


    @PostMapping("crearEcografia")
    public ResponseEntity<String> crearEcografia(@RequestBody ecografia ecografia){

        ecografia nuevaecografia=this.impl.crearEcografia(ecografia);

        if (nuevaecografia!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("ecografia creada");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear ");
        }
    }

    @GetMapping("buscarXnombre/{nombre}")
    public ResponseEntity<ecografia>buscarXnombre(@PathVariable String nombre){
        ecografia buscarEcogra=this.impl.buscarXnombre(nombre);

        if (buscarEcogra!=null){
            return ResponseEntity.ok(buscarEcogra);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

  @PutMapping("modificarEcografia/{idEcogra}")
  public ResponseEntity<String>modificarEcografia(@PathVariable int idEcogra, @RequestBody ecografia ecografias){

      ecografia buscarecografia=this.impl.busarecografia(idEcogra);

    if (buscarecografia!=null){

      ecografia modificarEcografia=this.impl.modificarEcografia(idEcogra,ecografias);

      if (modificarEcografia!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");
      }else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se modifico nada");
      }


    }else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro ecografia");
    }


  }
}
