package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.consultaMedica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface consultaMedicaRepo extends CrudRepository<consultaMedica,Integer> {

@Query(value = "select * from consulta_medica where nombre=?",nativeQuery = true)

  consultaMedica buscarXnombre(@Param("nombre") String nombre);
}
