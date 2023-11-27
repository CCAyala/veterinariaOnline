package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.citaServicioIMPL;
import com.example.veterinariaf.entity.citaMedicaDTo;
import com.example.veterinariaf.entity.citaServicioDTO;
import com.example.veterinariaf.entity.cita_medica;
import com.example.veterinariaf.entity.cita_servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citaServicio")
@CrossOrigin(origins = {"*"})
public class controler_citaServicio {


    private  final citaServicioIMPL impl;

    @Autowired
    public controler_citaServicio(citaServicioIMPL impl){
        this.impl=impl;
    }

    @GetMapping("listarCitaServicio")
    public ResponseEntity<List<citaServicioDTO>> listarCitaMedica(){
        List<citaServicioDTO> listarCitas=this.impl.listadeCitaSevicio();
        return ResponseEntity.ok(listarCitas);
    }


    @PostMapping("crearCitaServicio/{nombre}/{nombreSe}/{nombreV}")
    public ResponseEntity<String>crearCitaMedica(
            @RequestBody cita_servicio citaServicio,
            @PathVariable String nombre,
            @PathVariable String nombreSe,
            @PathVariable String nombreV){

        cita_servicio citaNueva=this.impl.crearCita(citaServicio,nombre,nombreSe,nombreV);

        if (citaNueva!=null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(" su cita medica a sido creada");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear");
        }

    }
}
