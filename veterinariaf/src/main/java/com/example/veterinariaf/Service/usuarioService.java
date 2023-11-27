package com.example.veterinariaf.Service;


import com.example.veterinariaf.entity.usuario;
import com.example.veterinariaf.repositorio.administradorRepo;
import com.example.veterinariaf.repositorio.propietarioRepo;
import com.example.veterinariaf.repositorio.usuarioRepositorio;
import com.example.veterinariaf.repositorio.veterinarioRepo;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service
public class usuarioService {

    private usuarioRepositorio repositorio;
    private propietarioRepo PropietarioRepo;
    private veterinarioRepo VeterinarioRepo;
    private administradorRepo AdministradorRepo;

    public usuarioService(usuarioRepositorio repositorio, propietarioRepo propietarioRepo, veterinarioRepo veterinarioRepo, administradorRepo administradorRepo) {
        this.repositorio = repositorio;
        PropietarioRepo = propietarioRepo;
        VeterinarioRepo = veterinarioRepo;
        AdministradorRepo = administradorRepo;
    }

    public usuario crear(usuario usuario){
        return repositorio.save(usuario);
    }


    public usuario buscarEmail(String email){

        if(repositorio.findById(email).isPresent()){
            return  this.repositorio.findById(email).get();
        }else{
            return null;
        }

    }

    public usuario getCrearUsuario(Map<String, Object> dataUser){

        String email= (String) dataUser.get("email");
        // System.out.println(email);
        usuario user=buscarEmail(email); //Si ya existe solo lo retorna
        String rol="";
        if(user==null) {
            String name = (String) dataUser.get("nickname");
            String imag = (String) dataUser.get("picture");
            String auth_id = (String) dataUser.get("sub");
            //Estudiante est=repoEst.findByCorreo(email);
            if(PropietarioRepo.findByEmail(email)!=null){
                rol="propietario";
            } else if (VeterinarioRepo.findByEmail(email)!=null) {
                rol="veterinario";
            } else if (AdministradorRepo.findByEmail(email)!=null) {
                rol="administrador";
            } else {
                rol="Otro";
            }
            usuario nuevo = new usuario(email, name, imag, auth_id,rol);
            return this.crear(nuevo);
        }else{
            return user;
        }


    }
}
