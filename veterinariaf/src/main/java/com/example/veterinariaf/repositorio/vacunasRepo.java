package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.vacunas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface vacunasRepo extends CrudRepository<vacunas, Integer> {

    @Query(value = "select * from vacunas where nombre =?",nativeQuery = true)
    vacunas buscarXnombre(@Param("nombre") String nombre);
}
