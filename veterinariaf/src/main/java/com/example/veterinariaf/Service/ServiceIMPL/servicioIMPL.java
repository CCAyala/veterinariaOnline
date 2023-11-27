package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.servicioService;
import com.example.veterinariaf.entity.servicios;
import com.example.veterinariaf.repositorio.servicioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class servicioIMPL implements servicioService {



    private final servicioRepo repo;
    @Autowired
    public servicioIMPL(servicioRepo repo){
        this.repo=repo;
    }



    @Override
    public List<servicios> listarServicios() {
       return (List<servicios>) this.repo.findAll();

    }

    @Override
    public servicios crearServicio(servicios servicio) {
        return this.repo.save(servicio);
    }

    @Override
    public servicios modificarServicio(int idServicio, servicios servicio) {
        servicios buscarServicio= this.buscarServicio(idServicio);

        if (buscarServicio!=null){

            servicios servicioExistente=buscarServicio;
            servicioExistente.setNombre(servicio.getNombre());
            servicioExistente.setTipoServicio(servicio.getTipoServicio());

            servicios servicioModificado=this.repo.save(servicioExistente);

            if(servicioModificado != null){
                return  servicioModificado;
            }else {
                throw  new RuntimeException("modificacion no exitosa");
            }
        }else {
            throw  new RuntimeException("servicio no existente");
        }
    }

    @Override
    public servicios buscarServicio(int idServicio) {
        return this.repo.findById(idServicio).get();
    }

    @Override
    public servicios buscarXnombre(String nombre) {

        servicios buscarXnombre=this.repo.buscarXnombre(nombre);

        if (buscarXnombre!= null){
            return  buscarXnombre;
        }else {

           throw  new RuntimeException("no se encontro servicio");
        }
    }
}
