package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.citaLaboraIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.mascotaIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.veterinarioIMPL;
import com.example.veterinariaf.entity.citaLaboratotioDto;
import com.example.veterinariaf.entity.cita_laboratorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citaLaboratorio")
@CrossOrigin(origins = {"*"})
public class citaLabora_Controler {

    private  final citaLaboraIMPL impl;

    private final mascotaIMPL implMasco;

    private final veterinarioIMPL implVete;

    public citaLabora_Controler(citaLaboraIMPL impl,mascotaIMPL implMasco,veterinarioIMPL implVete){
        this.impl=impl;
        this.implMasco=implMasco;
        this.implVete=implVete;
    }


    @GetMapping("listarCitasLabora")
    public ResponseEntity <List<citaLaboratotioDto>>listarCitasLabora(){
        List<citaLaboratotioDto> listarcitasL=this.impl.listarCitas();
        return ResponseEntity.ok(listarcitasL);
    }


    @PostMapping("crearCitaLabora/{nombre}/{nombre_prueba}/{nombre_completo}")
    public ResponseEntity<Object> crearCitaLaboratorio(
            @RequestBody cita_laboratorio citaLaboratorio,
            @PathVariable String nombre,
            @PathVariable String nombre_prueba,
            @PathVariable String nombre_completo) {


        cita_laboratorio citaCreada = this.impl.crearCitaLabora(
                citaLaboratorio,nombre,nombre_completo,nombre_prueba);

        if (citaCreada != null) {
            return ResponseEntity.ok("su cita a laboratorio a sido creada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear la cita");
        }
    }
}
