package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.registroDTo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface registroRepo extends CrudRepository<registro,Integer>{

    @Query(value = "select * from registro where codmascota=?",nativeQuery = true)
    List<registro> findBymascotascod_mascotas(@Param("codmascota")int codmascota);


    @Query(value = "SELECT cod_registro, estado_cardio_muscular,estado_digestivo,estado_respiratorio,estado_genitario,estado_locomocion,estado_moduloslinfaticos,estadom_musculo_esqueletico,estado_ojos,estado_pielyanex,estado_sistema_nervioso,fecha_ing,nombre  FROM Registro r JOIN Mascota m ON r.codmascota = m.codmasco ORDER BY cod_registro ASC",nativeQuery = true)
    List<Object[]> ListaConcodigoMascota();


    @Query(value = "SELECT r.cod_registro, r.estado_cardio_muscular, r.estado_digestivo, r.estado_respiratorio, \n" +
            "       r.estado_genitario, r.estado_locomocion, r.estado_moduloslinfaticos, \n" +
            "       r.estadom_musculo_esqueletico, r.estado_ojos, r.estado_pielyanex, \n" +
            "       r.estado_sistema_nervioso, r.fecha_ing, m.nombre\n" +
            "FROM Registro r\n" +
            "JOIN Mascota m ON r.codmascota = m.codmasco\n" +
            "WHERE m.nombre = ?",nativeQuery = true)
    List<Object[]> buscarPorNombre(@Param("nombre") String nombre);


    @Query(value = " SELECT r.cod_registro, r.estado_cardio_muscular, r.estado_digestivo, r.estado_respiratorio,\n" +
            "       r.estado_genitario, r.estado_locomocion, r.estado_moduloslinfaticos,\n" +
            "       r.estadom_musculo_esqueletico, r.estado_ojos, r.estado_pielyanex,\n" +
            "       r.estado_sistema_nervioso, r.fecha_ing, m.nombre\n" +
            "FROM registro r\n" +
            "INNER JOIN mascota m ON r.codmascota = m.codmasco\n" +
            "WHERE r.cod_registro = ?",nativeQuery = true)
    registroDTo buscarRegistross(@Param("codRegistro") int codRegistro);
}
