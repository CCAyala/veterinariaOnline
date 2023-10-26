package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.mascota;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface mascotaRepo extends CrudRepository<mascota, Integer> {

    @Query(value = "select * from  mascota where nombre =?",nativeQuery = true)
    mascota buscarXnombre(@Param("nombre") String nombre);
}
