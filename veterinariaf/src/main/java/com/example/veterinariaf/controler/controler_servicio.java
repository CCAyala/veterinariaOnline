package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.servicioIMPL;
import com.example.veterinariaf.entity.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servicio")
@CrossOrigin(origins = {"*"})
public class controler_servicio {


    private final servicioIMPL impl;

    @Autowired
    public controler_servicio(servicioIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarServicio")
    public ResponseEntity<List<servicios>>listarServicio(){
        List<servicios> listarServicios=this.impl.listarServicios();
        return ResponseEntity.ok(listarServicios);
    }



    @PostMapping("crearServicio")
    public ResponseEntity<servicios> crearServicio(@RequestBody servicios servicio){

        servicios nuevoServicio=this.impl.crearServicio(servicio);

        if (nuevoServicio != null){

            return  ResponseEntity.status(HttpStatus.CREATED).body(nuevoServicio);
        }else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("modificarServicio/{idServicio}")
    public ResponseEntity<servicios> modificarServicio(@PathVariable int idServicio, @RequestBody servicios servicio){

        servicios buscarSer=this.impl.buscarServicio(idServicio);

        if (buscarSer!=null){

            servicios modificarServicio=this.impl.modificarServicio(idServicio,servicio);

            if (modificarServicio != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(modificarServicio);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }


    @GetMapping("buscarServicio/{idServicio}")
    public ResponseEntity<servicios> buscarServicio(@PathVariable int idServicio){

        servicios buscarServicio= this.impl.buscarServicio(idServicio);

        if (buscarServicio != null){
            return  ResponseEntity.ok(buscarServicio);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
