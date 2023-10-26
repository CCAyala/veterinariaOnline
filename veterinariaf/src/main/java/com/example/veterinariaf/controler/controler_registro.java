package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.mascotaIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.registroIMPL;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.registroDTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("registro")
@CrossOrigin({"*"})
public class controler_registro {


    private registroIMPL impl;

    private mascotaIMPL implm;

    @Autowired
    public controler_registro(registroIMPL impl, mascotaIMPL implm){
        this.impl=impl;
        this.implm=implm;
    }




    @GetMapping("listaRegistro")
    public ResponseEntity<List<registroDTo>> obtenerRegistrosDTO() {
        List<registroDTo> registrosDTO = this.impl.ListaConcodigoMascota();
        return ResponseEntity.ok(registrosDTO);
    }

    @PostMapping("crearRegistro/{codmascota}")
    public ResponseEntity<registro>crearRegistro(@RequestBody registro registros, @PathVariable int codmascota) throws Exception {

        mascota buscandoMascota = this.implm.buscarMascota(codmascota);

        if (buscandoMascota != null) {
            registros.setMascotas(buscandoMascota);
            registro nuevoRegistro = this.impl.crearRegistro(registros);

            if (nuevoRegistro != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
            }else {
                throw new Exception("No se pudo crear el registro");
            }


        }else {          throw new Exception("La mascota no se ha encontrado");
        }


    }


    @GetMapping("buscarRegistro/{codmascota}")
    public ResponseEntity<List<registro>>buscarRegistro(@PathVariable int codmascota){
        List<registro> buscarmascota=this.impl.findBymascotascod_masco(codmascota);
        if (!buscarmascota.isEmpty()){
            return ResponseEntity.ok(buscarmascota);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }



    }



    @GetMapping("buscar/{codRegistro}")
    public ResponseEntity<registro> buscar(@PathVariable int codRegistro){
        registro buscarregistro=this.impl.buscarRegistros(codRegistro);
        return ResponseEntity.status(HttpStatus.CREATED).body(buscarregistro);
    }


    @GetMapping("buscarRegistross/{codRegistro}")
    public ResponseEntity<registroDTo> buscarregistro(@PathVariable int codRegistro){
        registroDTo buscarregistro=this.impl.buscarRegistross(codRegistro);
        return ResponseEntity.status(HttpStatus.CREATED).body(buscarregistro);
    }

    @GetMapping("buscregistro/{codigoRegistro}")
    public ResponseEntity<Map<String, Object>> obtenerRegistro(@PathVariable int codigoRegistro) {
        Map<String, Object> resultado = this.impl.obtenerCamposEspecificos(codigoRegistro);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("buscarPorNombre/{nombre}")
    public ResponseEntity<Object[]> buscarPorNombre(@PathVariable String nombre){
        registro buscaRegistro= (registro) this.impl.buscarPorNombre(nombre);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new registro[]{buscaRegistro});
    }


    @PutMapping("modificarRegistro/{codRegistro}")

    public ResponseEntity<registro> modificarRegistro(@RequestBody registro registros,@PathVariable int codRegistro){

        registro buscarRegistro=this.impl.buscarRegistros(codRegistro);

        if (buscarRegistro!=null){
            registro registroExistente= buscarRegistro;

            registroExistente.setEstadoCardioMuscular(registros.getEstadoCardioMuscular());
            registroExistente.setEstadoDigestivo(registros.getEstadoDigestivo());
            registroExistente.setEstadoGenitario(registros.getEstadoGenitario());
            registroExistente.setEstadoLocomocion(registros.getEstadoLocomocion());
            registroExistente.setEstadomMusculoEsqueletico(registros.getEstadomMusculoEsqueletico());
            registroExistente.setEstadoOjos(registros.getEstadoOjos());
            registroExistente.setEstadoPielyanex(registros.getEstadoPielyanex());
            registroExistente.setEstadoRespiratorio(registros.getEstadoRespiratorio());
            registroExistente.setFechaIng(registros.getFechaIng());
            registroExistente.setEstadoModuloslinfaticos(registros.getEstadoModuloslinfaticos());
            registroExistente.setEstadoSistemaNervioso(registros.getEstadoSistemaNervioso());

            registro registroModificado= this.impl.modificarRegistro(codRegistro,registros);

            if (registroModificado != null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }else {
                return ResponseEntity.status(HttpStatus.CREATED).body(registroModificado);
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}


