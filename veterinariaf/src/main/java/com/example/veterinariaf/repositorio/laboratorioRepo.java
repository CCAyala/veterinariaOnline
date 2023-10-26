package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.Laboratorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface laboratorioRepo extends CrudRepository<Laboratorio,Integer> {

    @Query(value = "select * from laboratorio where nombre=?",nativeQuery = true)
    Laboratorio buscarXnombre(@Param("nombre") String nombre);
}
