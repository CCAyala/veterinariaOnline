package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.propietarioService;
import com.example.veterinariaf.entity.propietario;
import com.example.veterinariaf.repositorio.propietarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class propietarioIMPL implements propietarioService {

    private final propietarioRepo repo;

    @Autowired
    public propietarioIMPL(propietarioRepo repo){
        this.repo=repo;
    }
    @Override
    public List<propietario> listarPropietarios() {
        return (List<propietario>) this.repo.findAll();
    }

    @Override
    public propietario crearPropietario(propietario propietario) {
        return this.repo.save(propietario);
    }

    @Override
    public propietario buscarPropietario(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public propietario findByPropietarioXcedula(int cedula) {
        List<propietario> propietariosList=this.repo.findByPropietarioXcedula(cedula);
        if (!propietariosList.isEmpty()){
            System.out.println("propietario encontrado");
            return propietariosList.get(0);
        }
        return null;
    }

    @Override
    public propietario modificarPropietario(propietario propietario, int cedula) {
        propietario buscarPropietario=this.findByPropietarioXcedula(cedula);

        if(buscarPropietario != null){
            return this.repo.save(propietario);
        }else {
            System.out.println("el propietario no se encontro");
        }
        return null;
    }

    @Override
    public void eliminarPropietario(int id) {

    }
}
