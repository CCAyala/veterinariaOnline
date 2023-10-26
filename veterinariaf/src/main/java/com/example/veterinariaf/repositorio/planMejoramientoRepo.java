package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.planMejoramiento;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface planMejoramientoRepo extends CrudRepository<planMejoramiento, Integer> {

  @Query(value = "select pm.fecha, pm.descripcion,\n" +
    "pm.cantidad,\n" +
    "pm.incapacidad,\n" +
    "v.nombre as nombre_veterinario,\n" +
    "m.nombre as nombre_mascota\n" +
    "from \n" +
    "plan_mejoramiento pm\n" +
    "JOIN\n" +
    "    diagnostico d ON pm.id_diagnostico = d.n_diagnostico\n" +
    "JOIN\n" +
    "    analisis a ON d.cod_analisis = a.cod_analisis\n" +
    "JOIN\n" +
    "    registro r ON a.codregistro = r.cod_registro\n" +
    "JOIN\n" +
    "    mascota m ON r.codmascota = m.codmasco\n" +
    "JOIN\n" +
    "    veterinario v ON pm.id_veterinario = v.cod_veterinario;",nativeQuery = true)
  List<Object[]> listarPLanMejoramiento();
}
