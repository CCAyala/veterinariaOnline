package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.propietario;
import com.example.veterinariaf.entity.veterinario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface propietarioRepo extends CrudRepository<propietario, Integer> {

    @Query(value = "select p from propietario p where p.cedula =:cedula")
    List<propietario> findByPropietarioXcedula(@Param("cedula") int cedula);

    propietario findByEmail(String correo);

}
