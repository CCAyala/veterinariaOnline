package com.example.veterinariaf.repositorio;


import com.example.veterinariaf.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface usuarioRepositorio extends JpaRepository<usuario,String> {

    usuario findByEmail(String email);
}