package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.registroService;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.registroDTo;
import com.example.veterinariaf.repositorio.mascotaRepo;
import com.example.veterinariaf.repositorio.registroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class registroIMPL implements registroService {

    private final registroRepo repo;
    private  final mascotaRepo repos;

    @Autowired
    public registroIMPL(registroRepo repo, mascotaRepo repos) {
        this.repo = repo;
        this.repos = repos;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<registro> listarRegistro() {
        return (List<registro>) this.repo.findAll();
    }

    @Override
    public List<registroDTo> ListaConcodigoMascota() {

        List<Object[]> resultado=this.repo.ListaConcodigoMascota();
        List<registroDTo> registroDToList=new ArrayList<>();

        for (Object[] resultados: resultado){
            registroDToList.add(new registroDTo(
                    (int) resultados[0],
                    (String)resultados[1],
                    (String)resultados[2],
                    (String)resultados[3],
                    (String) resultados[4],
                    (String) resultados[5],
                    (String) resultados[6],
                    (String) resultados[7],
                    (String) resultados[8],
                    (String) resultados[9],
                    (String) resultados[10],
                    (Date) resultados[11],
                    (String) resultados[12]

            ));
        }
        return registroDToList;
    }

    @Override
    public registro crearRegistro(registro registros) {
        mascota buscarMAscota=registros.getMascotas();

        if (buscarMAscota != null){
            Optional<mascota> optionalMascotas=this.repos.findById(buscarMAscota.getCodmasco());
            if (optionalMascotas.isPresent()){
                registros.setMascotas(optionalMascotas.get());
                return this.repo.save(registros);
            }else {
                System.out.println("registro NULADO ");
            }

        }else {
            System.out.println("la mascota no se ah encontrado");
        }
        return null;
    }

    @Override
    public List<registro> findBymascotascod_masco(int cod_mascota) {
        return this.repo.findBymascotascod_mascotas(cod_mascota);
    }

    @Override
    public registro buscarRegistros(int codRegistro) {
        return this.repo.findById(codRegistro).get();
    }

    @Override
    public registroDTo buscarRegistross(int codregistro) {
        return this.repo.buscarRegistross(codregistro);
    }


    @Override
    public List<Object[]> buscarPorNombre(String nombre) {
        return Collections.singletonList(this.repo.buscarPorNombre(nombre).get(0));
    }

    @Override
    public registro modificarRegistro(int codRegistro, registro registros) {
        Optional<registro> buscarregistro=this.repo.findById(codRegistro);

          if (buscarregistro.isPresent()){
              registro registroExistente= buscarregistro.get();

              registro registroModificado=this.repo.save(registroExistente);
          }else {
              System.out.println("no se encontro  registro");
          }
          return null;
    }

    @Override
    public registro eliminarRegistro(int codRegistro) {
        Optional<registro> buscarregistro=this.repo.findById(codRegistro);

        if (buscarregistro.isPresent()){
            registro registroExistente=buscarregistro.get();
            this.repo.deleteById(registroExistente.getCodRegistro());
        }
        else {
            System.out.println("registro no encontrado");
        }
        return null;
    }

    public Map<String, Object> obtenerCamposEspecificos(int codigoRegistro) {
        String sql = "SELECT r.cod_registro, r.nombreMasco, r.fechaIng FROM registroDTo r WHERE r.codRegistro = ?";
        return jdbcTemplate.queryForMap(sql, codigoRegistro);
    }



}
