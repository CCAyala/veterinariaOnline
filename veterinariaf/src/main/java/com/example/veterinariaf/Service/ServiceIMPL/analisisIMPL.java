package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.analisisService;
import com.example.veterinariaf.entity.analisis;
import com.example.veterinariaf.entity.analisisDTO;
import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.repositorio.analisisRepo;
import com.example.veterinariaf.repositorio.registroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class analisisIMPL implements analisisService {


    private final analisisRepo repo;
    private final registroRepo repoR;

    @Autowired

    public analisisIMPL(analisisRepo repo,registroRepo repoR){
        this.repo=repo;
        this.repoR=repoR;
    }

    @Override
    public List<analisisDTO> listarAnalisis() {

        List<Object[]> resultado=this.repo.listarAnalisisConRegistro();
        List<analisisDTO> analisisDTOList=new ArrayList<>();
        for (Object[] resultados :resultado){
            analisisDTOList.add(new analisisDTO(
                    (int) resultados[0],
                    (String) resultados[1],
                    (String) resultados[2],
                    (String) resultados[3],
                    (String) resultados[4],
                    (String) resultados[5],
                    (String) resultados[6],
                    (String)resultados[7],
                    (String)resultados[8],
                    (String) resultados[9],
                    (String) resultados[10]
            ));
        }

        return analisisDTOList;
    }

    @Override
    public List<analisis> listaAnalisis() {
        return (List<analisis>) this.repo.findAll();
    }

    @Override
    public analisis crearAnalisis(analisis analisa) {

        registro buscarRegistro= analisa.getRegistro();
        if (buscarRegistro!=null){
            Optional<registro> optionalRegistro=this.repoR.findById(buscarRegistro.getCodRegistro());
            if (optionalRegistro.isPresent()){
                analisa.setRegistro(optionalRegistro.get());

                return this.repo.save(analisa);

            }else {
                System.out.println("no se creo el analisis");
            }

        }else {
            System.out.println("no se encontro registro");
        }
        return null;
    }

    @Override
    public analisis modificarAnalisis(analisis analisa, int codAnalisis) {
        Optional<analisis> buscarAnalisis= this.repo.findById(codAnalisis);
        if (!buscarAnalisis.isEmpty()){
            analisis analisisExistente=buscarAnalisis.get();
            analisisExistente.setActitud(analisa.getActitud());
            analisisExistente.setCondicorporal(analisa.getCondicorporal());
            analisisExistente.setEstadoconjutival(analisa.getEstadoconjutival());
            analisisExistente.setEstadomucoso(analisa.getEstadomucoso());
            analisisExistente.setEstadohidratacion(analisa.getEstadohidratacion());
            analisisExistente.setOral(analisa.getOral());
            analisisExistente.setRectal(analisa.getRectal());
            analisisExistente.setObservaciones(analisisExistente.getObservaciones());
            analisisExistente.setVulvarpropulcal(analisa.getVulvarpropulcal());

            analisis analisisModificado=this.repo.save(analisisExistente);
            if (analisisModificado!=null){
                System.out.println("se ha modificado con exito");
            }else {
                System.out.println("error no se modifico nada");
            }
        }

        return null;

    }

    @Override
    public List<analisis> buscarAnalisisPorRegistro(int codregistro) {
        return this.repo.buscarAnalisisPorRegistro(codregistro);
    }

    @Override
    public analisis buscarAnalisis(int codAnalisis) {
        return this.repo.findById(codAnalisis).get();
    }

    @Override
    public List<Object[]> buscarAnalisisXmasco(String nombre) {
        List<Object[]> buscar=this.repo.buscarAnalisisXmasco(nombre);

        return buscar;
    }


}
