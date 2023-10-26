package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.cita_laboratorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface citaLaboraRepo extends CrudRepository<cita_laboratorio,Integer> {

    @Query(value = "SELECT\n" +

            "    cl.fecha_cita,\n" +
            "    cl.hora,\n" +
            "    l.nombre as nombre_Prueba,\n" +
            "    v.nombre as nombre_veterinario,\n" +
            "    m.nombre as nombre_mascota\n" +
            "FROM\n" +
            "    cita_laboratorio cl\n" +
            "JOIN\n" +
            "    laboratorio l ON cl.idlaboratorio = l.id_labora\n" +
            "JOIN\n" +
            "    veterinario v ON cl.id_veterinario = v.cod_veterinario\n" +
            "JOIN\n" +
            "    mascota m ON cl.cod_masco = m.codmasco;",nativeQuery = true)
    List<Object[]> listaDeCitasLabora();
}
