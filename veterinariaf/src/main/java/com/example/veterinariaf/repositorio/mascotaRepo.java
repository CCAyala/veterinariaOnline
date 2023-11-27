package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.mascota;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface mascotaRepo extends CrudRepository<mascota, Integer> {

    @Query(value = "select * from  mascota where nombre =?",nativeQuery = true)
    mascota buscarXnombre(@Param("nombre") String nombre);


    @Query(value = "select m.codmasco,m.nombre,p.nombre_completo,m.color,m.especie,m.fechanaci,m.raza\n" +
            "from mascota m\n" +
            "join propietario p on m.propietario_id = p.id",nativeQuery = true)
    List<Object[]> listarMascotaConnombre();
}
