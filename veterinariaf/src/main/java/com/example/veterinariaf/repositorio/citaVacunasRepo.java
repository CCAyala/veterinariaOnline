package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.citaVacunaDTo;
import com.example.veterinariaf.entity.cita_vacunas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface citaVacunasRepo extends CrudRepository<cita_vacunas,Integer> {

    @Query(value = "SELECT\n" +
            "    \n" +
            "    cv.fecha_cita,\n" +
            "    cv.hora,\n" +
            "    va.nombre as nombre_vacuna,\n" +
            "    v.nombre as nombre_veterinario,\n" +
            "    m.nombre as nombre_mascota\n" +
            "FROM\n" +
            "    cita_vacunas cv\n" +
            "JOIN\n" +
            "    vacunas va ON cv.id_vacuna = va.id_vacuna\n" +
            "JOIN\n" +
            "    veterinario v ON cv.id_veterinario = v.cod_veterinario\n" +
            "JOIN\n" +
            "    mascota m ON cv.cod_masco = m.codmasco;",nativeQuery = true)
    List<Object[]> listarCitasVacunas();
}
