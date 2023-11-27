package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.veterinario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface veterinarioRepo extends CrudRepository<veterinario,Integer> {

    @Query(value = "select * from veterinario where cedula=?",nativeQuery = true)
    List<veterinario> findByVeterinarioXcedula(@Param("cedula") int cedula);


    @Query(value = "select cod_veterinario,nombre ,cedula, especialidad,telefono from veterinario where nombre=?",nativeQuery = true)
     veterinario buscarPorNombre(@Param( "nombre") String nombre);

    veterinario findByEmail(String correo);
}
