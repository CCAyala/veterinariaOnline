package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.cita_cirugia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface citaCirugiaRepo extends CrudRepository<cita_cirugia,Integer> {

  @Query(value = "SELECT\n" +
    "    \n" +
    "    cc.fecha_cita,\n" +
    "    cc.hora,\n" +
    "    c.nombre as nombre_Cirugia,\n" +
    "    v.nombre as nombre_veterinario,\n" +
    "    m.nombre as nombre_mascota\n" +
    "FROM\n" +
    "    cita_cirugia cc\n" +
    "JOIN\n" +
    "    cirugias c ON c.id_cirugia = cc.id_cirugia\n" +
    "JOIN\n" +
    "    veterinario v ON cc.id_veterinario = v.cod_veterinario\n" +
    "JOIN\n" +
    "    mascota m ON cc.cod_masco = m.codmasco",nativeQuery = true)
  List<Object[]>listarCitaCirugia();
}
