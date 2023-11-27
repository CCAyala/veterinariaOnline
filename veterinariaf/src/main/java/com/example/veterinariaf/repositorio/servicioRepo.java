package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.servicios;
import com.example.veterinariaf.entity.vacunas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface servicioRepo extends CrudRepository<servicios, Integer> {

    @Query(value = "select * from servicios where nombre =?",nativeQuery = true)
    servicios buscarXnombre(@Param("nombre") String nombre);
}
