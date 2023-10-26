package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.cirugias;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface cirugiasRepo extends CrudRepository<cirugias, Integer> {

  @Query(value = "select * from cirugias where nombre=?",nativeQuery = true)
  cirugias buscarXnombre(@Param("nombre") String nombre);
}
