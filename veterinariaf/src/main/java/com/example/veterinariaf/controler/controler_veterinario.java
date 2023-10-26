package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.veterinarioIMPL;
import com.example.veterinariaf.entity.veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veterinario")
@CrossOrigin({"*"})
public class controler_veterinario {


    private final veterinarioIMPL impl;

    @Autowired
    public controler_veterinario(veterinarioIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarVeterinarios")
    private ResponseEntity<List<veterinario>> listarVeterinarios(){
        List<veterinario> listarVeterinario=this.impl.ListarVeterirnarios();
        return ResponseEntity.ok(listarVeterinario);
    }

    @PostMapping("crearVeterinario")
    public ResponseEntity<String> crearVeterinario(@RequestBody veterinario veterinari){
        veterinario buscarVeterinario=this.impl.findByVeterinarioXcedula(veterinari.getCedula());
        if (buscarVeterinario!=null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el veterinario ya existe");
        }else {
            veterinario veterinar = this.impl.crearVeterinario(veterinari);
            if (veterinar != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("el veterinario ha sido creado");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se ha creado nada");
            }
        }
        return  ResponseEntity.ok("el veterinario ya existe");
    }

    @GetMapping("buscarVeterinario/{cedula}")
    public ResponseEntity<veterinario> buscarVeterinario(@PathVariable int cedula){
        veterinario buscandoVeterinario=this.impl.findByVeterinarioXcedula(cedula);
        if(buscandoVeterinario != null) {
            return ResponseEntity.ok(buscandoVeterinario);
        }
        else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @GetMapping("buscarXnombre/{nombre}")
    public veterinario buscarXnombre(@PathVariable String nombre){

        veterinario buscando=this.impl.buscarPorNombre(nombre);
        if (buscando != null){
            return ResponseEntity.ok(buscando).getBody();

        }
        return buscando;
    }


    @PutMapping("modificarVeterinario/{cedula}")
    public ResponseEntity<String> modificarVeterinario(@PathVariable int cedula,@RequestBody veterinario veterinari) {
        veterinari.setCedula(cedula);
        veterinario modificarVete = this.impl.modificarVeterinario(veterinari, cedula);
        if (modificarVete != null) {

            return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("veterinario no existente");
        }
    }

}
