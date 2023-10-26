package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.analisis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface analisisRepo extends CrudRepository<analisis,Integer>{

@Query(value = "\n" +
        "select a.cod_analisis,m.nombre as nombre_mascota,a.actitud,a.condicorporal,a.estadoconjutival,a.estadohidratacion,a.estadomucoso,\n" +
        "a.oral,a.rectal,a.vulvarpropulcal,a.observaciones from analisis a \n" +
        "join registro r on\n" +
        "a.codregistro = r.cod_registro\n" +
        "join mascota m on r.codmascota = m.codmasco;\n",nativeQuery = true)
    List<Object[]> listarAnalisisConRegistro();

@Query(value = "select * from analisis where codregistro =?",nativeQuery = true)
    List<analisis> buscarAnalisisPorRegistro(@Param("codregistro") int codregistro);

@Query(value = "select a.cod_analisis,m.nombre as nombre_mascota,a.actitud,a.condicorporal,a.estadoconjutival,a.estadohidratacion,a.estadomucoso,\n" +
        "        a.oral,a.rectal,a.vulvarpropulcal,a.observaciones from analisis a \n" +
        "        join registro r on\n" +
        "        a.codregistro = r.cod_registro \n" +
        "        join mascota m on r.codmascota = m.codmasco\n" +
        "        where m.nombre = ?",nativeQuery = true)
    List<Object[]> buscarAnalisisXmasco(@Param("nombre") String nombre);

}
