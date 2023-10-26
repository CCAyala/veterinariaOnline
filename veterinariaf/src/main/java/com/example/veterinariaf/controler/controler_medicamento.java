package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.medicamentosIMPL;
import com.example.veterinariaf.entity.medicamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicamentos")
@CrossOrigin(origins = {"*"})
public class controler_medicamento {


    private final medicamentosIMPL impl;

    @Autowired

    public controler_medicamento(medicamentosIMPL impl) {
        this.impl = impl;
    }


    @GetMapping("listarMedicamentos")
    public ResponseEntity<List<medicamentos>> listarMedicamentos() {
        List<medicamentos> listarMedicamentos = this.impl.listarMedicamentos();
        return ResponseEntity.ok(listarMedicamentos);
    }


    @PostMapping("crearMedicamento")
    public ResponseEntity<medicamentos> crearMedicamento(@RequestBody medicamentos medicamento) {
        medicamentos nuevoMedicamento = this.impl.crearMedicamento(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedicamento);
    }


    @PutMapping("modificarMedicamento/{codMedi}")
    public ResponseEntity<medicamentos> modificarMedicamento(@PathVariable int codMedi, @RequestBody medicamentos medicamento) {
        medicamentos busca=this.impl.buscarMendicamento(codMedi);

        if (busca!=null){
            medicamentos moficicarMedi=this.impl.modificarmedicamento(codMedi,medicamento);
            if (moficicarMedi!=null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }else {
                return ResponseEntity.status(HttpStatus.CREATED).body(moficicarMedi);
            }

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("buscarXnombre/{nombreMedi}")
  public ResponseEntity<medicamentos>buscarXnombre(@PathVariable String nombreMedi){

      medicamentos buscarMedicamento=this.impl.buscarXnombre(nombreMedi);

      if (buscarMedicamento!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body(buscarMedicamento);
      }else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }

    }
}
