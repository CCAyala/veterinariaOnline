package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.administrador;
import com.example.veterinariaf.entity.propietario;
import org.springframework.data.repository.CrudRepository;

public interface administradorRepo extends CrudRepository<administrador, Integer> {

    administrador findByEmail(String correo);
}
