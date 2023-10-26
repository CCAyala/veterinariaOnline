package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.veterinarioService;
import com.example.veterinariaf.entity.veterinario;
import com.example.veterinariaf.repositorio.veterinarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class veterinarioIMPL implements veterinarioService {


    private final veterinarioRepo repo;

    @Autowired
    public veterinarioIMPL(veterinarioRepo repo){
        this.repo=repo;
    }

    @Override
    public List<veterinario> ListarVeterirnarios() {
        return(List<veterinario>) this.repo.findAll();
    }

    @Override
    public veterinario crearVeterinario(veterinario veterinari) {

        return this.repo.save(veterinari);
    }

    @Override
    public veterinario findByVeterinarioXcedula(int cedula) {
        List<veterinario> buscarVete= this.repo.findByVeterinarioXcedula(cedula);
        if (!buscarVete.isEmpty()){
            System.out.println("veterinario encontrado");
            return  buscarVete.get(0);
        }
        return null;
    }

    @Override
    public veterinario buscarPorNombre(String nombre) {
        return this.repo.buscarPorNombre(nombre);
    }


    @Override
    public veterinario modificarVeterinario(veterinario veterinari,int cedula) {
        veterinario buscarVete= this.findByVeterinarioXcedula(cedula);

        if (buscarVete!=null){
            return this.repo.save(veterinari);
        }else {
            System.out.println("no se encontro al veterinario");
        }
        return null;
    }

    @Override
    public void eliminarVeterinario(int cedula) {
        this.repo.deleteById( cedula);
    }


}
