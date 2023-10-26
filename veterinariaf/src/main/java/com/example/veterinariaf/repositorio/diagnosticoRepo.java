package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.diagnostico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface diagnosticoRepo extends CrudRepository<diagnostico,Integer> {

    @Query(value = "SELECT d.n_diagnostico, m.nombre AS nombre_mascota, d.descripccion, d.estado\n" +
      "FROM diagnostico d\n" +
      "JOIN analisis a ON d.cod_analisis = a.cod_analisis\n" +
      "JOIN registro r ON a.codregistro = r.cod_registro\n" +
      "JOIN mascota m ON r.codmascota = m.codmasco;",nativeQuery = true)
    List<Object[]> listaDiagnosticoConmasco();
}
