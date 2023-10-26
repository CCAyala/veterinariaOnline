package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.analisisIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.registroIMPL;
import com.example.veterinariaf.entity.analisis;
import com.example.veterinariaf.entity.analisisDTO;
import com.example.veterinariaf.entity.registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("analisis")
@CrossOrigin(origins = {"*"})
public class controler_analisis {

    private final analisisIMPL impl;

    private final registroIMPL implr;

    @Autowired

    public controler_analisis(analisisIMPL impl, registroIMPL implr) {
        this.impl = impl;
        this.implr = implr;
    }


    @GetMapping("listarAnalisis")
    public ResponseEntity<List<analisisDTO>> listarAnalisis() {
        List<analisisDTO> listarAnalisis = this.impl.listarAnalisis();
        return ResponseEntity.ok(listarAnalisis);
    }

    @GetMapping("buscarAnalisis/{codRegistro}")
    public  ResponseEntity<analisis>buscarAnalisis(@PathVariable int codRegistro){
        analisis buscarAnalisis=this.impl.buscarAnalisisPorRegistro(codRegistro).get(0);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(buscarAnalisis);
    }
    @PostMapping("crearAnalisis/{codRegistro}")
    public ResponseEntity<analisis> crearAnalisis(@RequestBody analisis analisa, @PathVariable int codRegistro) throws Exception {
        registro buscarregistro = this.implr.buscarRegistros(codRegistro);
        if (buscarregistro != null) {
            analisa.setRegistro(buscarregistro);

            analisis nuevoAnalisis = this.impl.crearAnalisis(analisa);
            if (nuevoAnalisis != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAnalisis);
            }else {
                throw new Exception("No se pudo crear el registro");
            }

        }else {
            throw new Exception("No se pudo crear el registro");
        }
    }

    @PutMapping("modificarAnalisis/{codAnalisis}")
    public ResponseEntity<String>modificarAnalisis(@RequestBody analisis analisa,@PathVariable int codAnalisis){
        analisis buscar=this.impl.buscarAnalisis(codAnalisis);

        if (buscar!=null){
            analisis analisisExistente=buscar;
            analisisExistente.setActitud(analisa.getActitud());
            analisisExistente.setCondicorporal(analisa.getCondicorporal());
            analisisExistente.setEstadoconjutival(analisa.getEstadoconjutival());
            analisisExistente.setEstadomucoso(analisa.getEstadomucoso());
            analisisExistente.setEstadohidratacion(analisa.getEstadohidratacion());
            analisisExistente.setOral(analisa.getOral());
            analisisExistente.setRectal(analisa.getRectal());
            analisisExistente.setVulvarpropulcal(analisa.getVulvarpropulcal());
            analisisExistente.setObservaciones(analisa.getObservaciones());

            analisis analisisModificado=this.impl.modificarAnalisis(analisa,codAnalisis);

            if (analisisModificado !=null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("analisis no modificado");
            }else {
                return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");
            }
        }
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("registro no existente");

    }

    @GetMapping("buscaAnalisis/{codAnalisis}")
    public ResponseEntity<analisis> buscaAnalisis(@PathVariable int codAnalisis){
        analisis buscarAnalsis=this.impl.buscarAnalisis(codAnalisis);

        return ResponseEntity.ok(buscarAnalsis);
    }




    @GetMapping("buscarXNombre/{nombre}")
    public ResponseEntity<List<analisisDTO>> buscarXnombre(@PathVariable String nombre){
        List<Object[]> resultado= this.impl.buscarAnalisisXmasco(nombre);
        List<analisisDTO> analisisDTOList= new ArrayList<>();

        for (Object[] resultados : resultado){
            analisisDTO dto= new analisisDTO();
            dto.setCodAnalisis((Integer) resultados[0]);
            dto.setNombre((String) resultados[1]);
            dto.setActitud((String) resultados[2] );
            dto.setCondicorporal((String) resultados[3]);
            dto.setEstadoconjutival((String) resultados[4]);
            dto.setEstadohidratacion((String) resultados[5]);
            dto.setEstadomucoso((String) resultados[6]);
            dto.setOral((String) resultados[7]);
            dto.setRectal((String) resultados[8]);
            dto.setVulvarpropulcal((String) resultados[9]);
            dto.setObservaciones((String) resultados[10]);

            analisisDTOList.add(dto);

        }
        return  ResponseEntity.ok(analisisDTOList);
    }

}
