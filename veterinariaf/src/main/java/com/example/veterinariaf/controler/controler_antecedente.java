package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.antecedenteIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.mascotaIMPL;
import com.example.veterinariaf.entity.antecedentes;
import com.example.veterinariaf.entity.mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("antecedentes")
@CrossOrigin({"*"})
public class controler_antecedente {


    private final antecedenteIMPL impl;

    private final mascotaIMPL implm;

    @Autowired
    public controler_antecedente(antecedenteIMPL impl, mascotaIMPL implm){
        this.impl=impl;
        this.implm=implm;
    }

    @GetMapping("listarAntecedente")
    public ResponseEntity<List<antecedentes>> listarAntecedentes(){
        List<antecedentes> listarantecedentes=this.impl.listarAntecendentes();
        return ResponseEntity.ok(listarantecedentes);
    }

    @PostMapping("crearAntecedente/{cod_mascota}")
    public antecedentes crearAntecedente(@RequestBody antecedentes antecedente, @PathVariable int cod_mascota){

        mascota mascota = this.implm.buscarMascota(cod_mascota);

        if (mascota != null) {
            antecedente.setMascota(mascota);
        }else {
            System.out.println("la mascota no se ha encontrado ");
        }
        antecedentes nuevoAntecedente = this.impl.crearAntecedente(antecedente);

        if (nuevoAntecedente != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAntecedente).getBody();
        }else {
            System.out.println("no se ha creado el antecedente");
        }
        return null;
    }


    @GetMapping("buscarAntecedente/{cod_mascota}")
    public ResponseEntity<List<antecedentes>> buscarAntecedentes(@PathVariable int cod_mascota){
        List<antecedentes> antecedentesList= this.impl.findBymascotascod_masco(cod_mascota);

        if (!antecedentesList.isEmpty()){
            return ResponseEntity.ok(antecedentesList);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("modificarAntecedentes/{cod_mascota}")
    public ResponseEntity<String> modificarAntecedentes(@RequestBody antecedentes antecedente,@PathVariable int cod_mascota){
        List<antecedentes>  antecedenteEncontrado= this.impl.findBymascotascod_masco(cod_mascota);
        if (antecedenteEncontrado!= null){

            antecedentes antecedenteEncontrados=antecedenteEncontrado.get(0);

            antecedenteEncontrados.setAlergias(antecedente.getAlergias());
            antecedenteEncontrados.setEstadoreproductivo(antecedente.getEstadoreproductivo());
            antecedenteEncontrados.setEstadocastracion(antecedente.getEstadocastracion());
            antecedenteEncontrados.setCirugiasanter(antecedente.getCirugiasanter());
            antecedenteEncontrados.setHabitad(antecedente.getHabitad());
            antecedenteEncontrados.setFechultidesparacitacion(antecedente.getFechultidesparacitacion());
            antecedenteEncontrados.setEnfermedadesante(antecedente.getEnfermedadesante());
            antecedenteEncontrados.setEstadoreproductivo(antecedente.getEstadoreproductivo());

            antecedentes antecedentemodificado=this.impl.modificarAntecedente(cod_mascota,antecedente);

            if (antecedentemodificado != null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se modifico nada");
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("se ha modificado con exito");
    }




}
