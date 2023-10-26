package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.cita_ecografia;
import com.example.veterinariaf.entity.ecografia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface citaEcografiaRepo extends CrudRepository<cita_ecografia, Integer> {

    @Query(value = "SELECT\n" +
            "    \n" +
            "    ce.fecha_cita,\n" +
            "    ce.hora,\n" +
            "    e.nombre as nombre_ecografia,\n" +
            "    v.nombre as nombre_veterinario,\n" +
            "    m.nombre as nombre_mascota\n" +
            "FROM\n" +
            "    cita_ecografia ce\n" +
            "JOIN\n" +
            "    ecografia e ON ce.id_ecografia = e.id_ecogra\n" +
            "JOIN\n" +
            "    veterinario v ON ce.id_veterinario = v.cod_veterinario\n" +
            "JOIN\n" +
            "    mascota m ON ce.cod_masco = m.codmasco;",nativeQuery = true)
    List<Object[]> listarCitaEcogra();
}
