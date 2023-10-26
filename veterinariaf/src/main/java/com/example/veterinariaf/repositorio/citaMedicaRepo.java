package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.cita_medica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface citaMedicaRepo extends CrudRepository<cita_medica,Integer> {

  @Query(value = "SELECT\n" +
    "    \n" +
    "    cm.fecha_cita,\n" +
    "    cm.hora,\n" +
    "    co.nombre as nombre_Consulta,\n" +
    "    v.nombre as nombre_veterinario,\n" +
    "    m.nombre as nombre_mascota\n" +
    "FROM\n" +
    "    cita_medica cm\n" +
    "JOIN\n" +
    "    consulta_medica co ON cm.id_consulta = co.id_consulta\n" +
    "JOIN\n" +
    "    veterinario v ON cm.id_veterinario = v.cod_veterinario\n" +
    "JOIN\n" +
    "    mascota m ON cm.cod_masco = m.codmasco;",nativeQuery = true)
  List<Object[]> listarCitaMedica();
}
