package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.mascotaService;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.propietario;
import com.example.veterinariaf.repositorio.mascotaRepo;
import com.example.veterinariaf.repositorio.propietarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mascotaIMPL implements mascotaService {

    private final mascotaRepo repo;
    private final propietarioRepo repoP;
    @Autowired
    public mascotaIMPL(mascotaRepo repo,propietarioRepo repoP){
        this.repo=repo;
        this.repoP=repoP;
    }
    @Override
    public List<mascota> listarMascotas() {
        return (List<mascota>) this.repo.findAll();
    }

    @Override
    public mascota crearMascota(mascota mascotas) {
        propietario buscarPropie=mascotas.getPropietario();
        if (buscarPropie !=null){
            Optional<propietario> optionalPropietarios=this.repoP.findById(buscarPropie.getId());
            if (optionalPropietarios.isPresent()){
                mascotas.setPropietario(optionalPropietarios.get());
                return this.repo.save(mascotas);
            }else {
                System.out.println("el propietario no existe");
            }
        }
        return null;
    }

    @Override
    public mascota modificarMascota(mascota mascotas) {
        if (this.repo.existsById(mascotas.getCodmasco())){
            return this.repo.save(mascotas);

        }else {
            System.out.println("no se encontro la mascota");
        }
        return null;
    }

    @Override
    public mascota buscarMascota(int codmasco) {
        return this.repo.findById(codmasco).get();
    }

    @Override
    public void eliminarMascota(int codmasco) {

    }

    @Override
    public mascota buscarXnombre(String nombre) {
        mascota buscarMascota= this.repo.buscarXnombre(nombre);

        if (buscarMascota!=null){
            return  buscarMascota;
        }else {
            throw new RuntimeException("mascota no encotrada");
        }
    }
}
