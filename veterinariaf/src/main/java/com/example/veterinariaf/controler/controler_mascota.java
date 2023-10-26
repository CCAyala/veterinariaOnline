package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.mascotaIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.propietarioIMPL;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mascota")
@CrossOrigin(origins = {"*"})
public class controler_mascota {

    private final mascotaIMPL impl;
    private final propietarioIMPL impls;
    @Autowired
    public controler_mascota(mascotaIMPL impl, propietarioIMPL impls){
        this.impl=impl;
        this.impls=impls;
    }


    @GetMapping("listarMascotas")
    public ResponseEntity<List<mascota>> listarMascotas(){
        List<mascota> listarMascota= this.impl.listarMascotas();
        return  ResponseEntity.ok(listarMascota);
    }



    @GetMapping("buscaMascota/{codmasco}")
    public ResponseEntity<mascota> buscarMacota(@PathVariable int codmasco ){
        mascota buscaMascota= this.impl.buscarMascota(codmasco);
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(buscaMascota);
    }

    @PostMapping(value = "crearMascota/{id}")
    public ResponseEntity<mascota>crearMascota(@RequestBody mascota mascotas, @PathVariable int id){

        propietario propietario=this.impls.buscarPropietario(id);
        if (propietario!=null){
            mascotas.setPropietario(propietario);
            mascota nuevaMascota=this.impl.crearMascota(mascotas);
            if (nuevaMascota!=null){
                return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }else {
            System.out.println("el propietario no existe");
        }
        return null;
    }


    @PutMapping("modificarMascota/{codmasco}")
    public ResponseEntity<mascota> modificarMascota(@RequestBody mascota mascotas,@PathVariable int codmasco){
        mascota mascotaEncontrada = this.impl.buscarMascota(codmasco);

        if (mascotaEncontrada != null){
            mascotaEncontrada.setNombre(mascotas.getNombre());
            mascotaEncontrada.setColor(mascotas.getColor());
            mascotaEncontrada.setEspecie(mascotas.getEspecie());
            mascotaEncontrada.setRaza(mascotas.getRaza());


            mascotaEncontrada.setPropietario(mascotas.getPropietario());

            mascota mascotaModicada= this.impl.modificarMascota(mascotaEncontrada);
            if (mascotaModicada != null){
                return ResponseEntity.ok(mascotaModicada);
            }else {
                System.out.println("no se pudo modificar la mascota");
            }

        }else {
            System.out.println("mascota no encontrada");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }



    @DeleteMapping("eliminarmascota/{codmsaco}")
    public void eliminarMascota(@PathVariable int codamasco){
        this.impl.eliminarMascota(codamasco);
    }



    @GetMapping("buscarXnombre/{nombre}")
    public ResponseEntity<mascota> buscarXnombre(@PathVariable String nombre){


        mascota buscarMascota=this.impl.buscarXnombre(nombre);

        if (buscarMascota!=null){
            return ResponseEntity.ok(buscarMascota);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}





