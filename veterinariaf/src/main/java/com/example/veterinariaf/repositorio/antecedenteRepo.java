package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.antecedentes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface antecedenteRepo extends CrudRepository<antecedentes, Integer> {

    @Query(value = "select * from antecedentes where cod_mascota=?",nativeQuery = true)
    List<antecedentes> findBymascotascod_mascotas(@Param("cod_mascota") int cod_mascota);


}
