package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.analisisIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.diagnosticoIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.registroIMPL;
import com.example.veterinariaf.entity.analisis;
import com.example.veterinariaf.entity.diagnostico;
import com.example.veterinariaf.entity.diagnosticoDTO;
import com.example.veterinariaf.entity.registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("diagnostico")
@CrossOrigin(origins = {"*"})
public class controler_diagnostico {


    private final diagnosticoIMPL impl;
    private final analisisIMPL implA;

    @Autowired

    public controler_diagnostico(diagnosticoIMPL impl,analisisIMPL implA){
        this.impl=impl;
        this.implA=implA;
    }


    @GetMapping("listarDiagnosticos")
    public ResponseEntity<List<diagnosticoDTO>> listarDiagnosticos(){
        List<diagnosticoDTO> listarDiagnosticos=this.impl.listaDiagnosticoConmasco();
        return ResponseEntity.ok(listarDiagnosticos);
    }


    @PostMapping(value = "crearDiagnostico/{codAnalisis}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<diagnostico> crearDiagnostico(@RequestBody diagnostico diagnosticos,@PathVariable int codAnalisis) {

        analisis buscarregistro=this.implA.buscarAnalisis(codAnalisis);

        if (buscarregistro!= null){
            diagnosticos.setAnalisis(buscarregistro);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        diagnostico nuevoDiagnostico=this.impl.crearDiagnostico(codAnalisis,diagnosticos);

        if (nuevoDiagnostico != null){
            ResponseEntity.status(HttpStatus.CREATED).body(nuevoDiagnostico);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDiagnostico);
    }

    @PutMapping("modificarDiagnostico/{nDiagnostico}")
    public  ResponseEntity<diagnostico>modificarDiagnostico(@PathVariable int nDiagnostico,@RequestBody diagnostico diagnosticos){

               diagnostico  buscandoDiagnostico=this.impl.buscarDiagnostico(nDiagnostico);
         if (buscandoDiagnostico!=null){

             diagnostico diagnosticoexistente= buscandoDiagnostico;

             diagnosticoexistente.setDescripccion(diagnosticos.getDescripccion());

             diagnosticoexistente.setEstado(diagnosticos.getEstado());

             diagnostico diagnosticoModificado= this.impl.modificarDiagnostico(nDiagnostico ,diagnosticoexistente);
             if (diagnosticoModificado != null){
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
             }else {
                 return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticoModificado);
             }
         }else {
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
         }
    }




   @GetMapping("buscarDiagnostico/{nDiagnotico}")
        public  ResponseEntity<diagnostico> buscarDiagnostico(@PathVariable int nDiagnotico){
        diagnostico buscarDiagnotico= this.impl.buscarDiagnostico(nDiagnotico);

        if (buscarDiagnotico!=null ){
            return ResponseEntity.status(HttpStatus.CREATED).body(buscarDiagnotico);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

   }







}
