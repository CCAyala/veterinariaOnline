package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.propietarioIMPL;
import com.example.veterinariaf.entity.propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("propietario")
@CrossOrigin(origins ={"*"})
public class controler_propietario {

    private final propietarioIMPL impl;

    @Autowired
    public controler_propietario(propietarioIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarPropietarios")
    public ResponseEntity<List<propietario>> listarPropietarios(){
        List<propietario>listarpropietarios=this.impl.listarPropietarios();
        return ResponseEntity.ok(listarpropietarios);
    }

    @PostMapping("crear")
    public ResponseEntity<String>crear(@RequestBody propietario propietarios){
        propietario nuevopropietario=this.impl.crearPropietario(propietarios);
        return ResponseEntity.status(HttpStatus.CREATED).body("el propietario a sido creado");
    }

    @PutMapping("modificarPropietario/{cedula}")
    public ResponseEntity<propietario>modificarPropietarios (@RequestBody propietario propietario,@PathVariable int cedula){
        propietario.setCedula(cedula);
        propietario modificarPropietarios = this.impl.modificarPropietario(propietario, cedula);

        if (modificarPropietarios != null) {
            return ResponseEntity.ok(modificarPropietarios);

        } else {
            System.out.println(" no se pudo modificar");
        }

        return null;
    }

    @GetMapping("buscarPropietario/{cedula}")
    public ResponseEntity<propietario> buscarPropietario(@PathVariable int cedula){
        propietario buscarPropietario= this.impl.findByPropietarioXcedula(cedula);
        return ResponseEntity.ok(buscarPropietario);
    }
}
