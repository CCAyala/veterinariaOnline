package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.ecografia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ecografiaRepo extends CrudRepository<ecografia, Integer> {

    @Query(value = "select * from ecografia where nombre =?",nativeQuery = true)
    ecografia buscarXnombre(@Param("nombre") String nombre);
}
