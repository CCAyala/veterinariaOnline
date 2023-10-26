package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.citaEcograIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.citaVacunaIMPL;
import com.example.veterinariaf.entity.citaEcografiaDTo;
import com.example.veterinariaf.entity.citaVacunaDTo;
import com.example.veterinariaf.entity.cita_ecografia;
import com.example.veterinariaf.entity.cita_vacunas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citaVacunas")
@CrossOrigin(origins = {"*"})
public class controler_citaVacuna {



    private final citaVacunaIMPL impl;

    @Autowired

    public controler_citaVacuna(citaVacunaIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarCitaVacuna")
    public ResponseEntity<List<citaVacunaDTo>> listarCitaVacuna(){
        List<citaVacunaDTo> listarCitas=this.impl.listarCitasVacunas();
        return ResponseEntity.ok(listarCitas);
    }


    @PostMapping("crearCitaVacuna/{nombre}/{nombreVa}/{nombreV}")
    public ResponseEntity<String>crearCitaVacuna(
            @RequestBody cita_vacunas citaVacunas,
            @PathVariable String nombre,
            @PathVariable String nombreVa,
            @PathVariable String nombreV){

        cita_vacunas citaNueva=this.impl.crearCitaVacuna(citaVacunas,nombre,nombreVa,nombreV);

        if (citaNueva!=null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(" su cita a ecografia a sido creada");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear");
        }

    }
}
