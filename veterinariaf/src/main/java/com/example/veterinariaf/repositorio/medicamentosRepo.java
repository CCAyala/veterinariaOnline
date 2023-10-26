package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.medicamentos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface medicamentosRepo extends CrudRepository<medicamentos, Integer> {

  @Query(value = "  select * from medicamentos where nombre=?",nativeQuery = true)
  medicamentos buscarXnombre(@Param("nombre") String nombre);
}
