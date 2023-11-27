package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.cita_servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface citaServicioRepo extends CrudRepository<cita_servicio,Integer> {

    @Query( value = "SELECT\n" +
            "        \n" +
            "        cs.fecha_cita,\n" +
            "        cs.hora,\n" +
            "        s.nombre as nombre_Consulta,\n" +
            "        v.nombre as nombre_veterinario,\n" +
            "        m.nombre as nombre_mascota\n" +
            "    FROM\n" +
            "     cita_servicio cs\n" +
            "    JOIN\n" +
            "    servicios s ON cs.id_servicio= s.id_servicio\n" +
            "    JOIN\n" +
            "     veterinario v ON cs.id_veterinario = v.cod_veterinario\n" +
            "    JOIN\n" +
            "     mascota m ON cs.cod_masco = m.codmasco",nativeQuery = true)
    List<Object[]> listadeCitaSevicio();
}

