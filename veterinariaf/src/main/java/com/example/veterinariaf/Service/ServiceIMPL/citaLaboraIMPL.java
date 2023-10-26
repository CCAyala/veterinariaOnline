package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.citaLaboraService;
import com.example.veterinariaf.entity.*;
import com.example.veterinariaf.registroDTo;
import com.example.veterinariaf.repositorio.citaLaboraRepo;
import com.example.veterinariaf.repositorio.laboratorioRepo;
import com.example.veterinariaf.repositorio.mascotaRepo;
import com.example.veterinariaf.repositorio.veterinarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class citaLaboraIMPL implements citaLaboraService {

    private final citaLaboraRepo repo;
    private final mascotaRepo repoMas;

    private final veterinarioRepo repoVete;

    private final laboratorioRepo repoLab;

    @Autowired
    public citaLaboraIMPL(citaLaboraRepo repo, mascotaRepo repoMas, veterinarioRepo repoVete,laboratorioRepo repoLab){
        this.repoMas=repoMas;
        this.repoVete=repoVete;
        this.repo=repo;
        this.repoLab=repoLab;
    }

    @Override
    public List<citaLaboratotioDto> listarCitas() {

        List<Object[]> resultado=this.repo.listaDeCitasLabora();
        List<citaLaboratotioDto> citaLaboratotioDtos=new ArrayList<>();

        for (Object[] resultados: resultado){
            citaLaboratotioDtos.add(new citaLaboratotioDto(

                    (Date) resultados[0],
                    (Time) resultados[1],
                    (String)resultados[2],
                    (String)resultados[3],
                    (String) resultados[4]


            ));
        }
        return citaLaboratotioDtos;
    }


    @Override
    public cita_laboratorio crearCitaLabora(cita_laboratorio citaLaboratorios, String nombre, String nombreP,String nombreV) {


        try {

            Optional<mascota> buscarMascota = Optional.ofNullable(repoMas.buscarXnombre(nombre));
            if (!buscarMascota.isPresent()) {
                 throw new RuntimeException("no se encontro la mascota");
            }


            Optional<veterinario> buscarVeterinario = Optional.ofNullable(repoVete.buscarPorNombre(nombreV));
            if (!buscarVeterinario.isPresent()) {
                throw new RuntimeException("veterinario no encontrado");
            }

            Optional<Laboratorio> buscarXnombre= Optional.ofNullable(this.repoLab.buscarXnombre(nombreP));

            if (!buscarXnombre.isPresent()) {

                throw new RuntimeException("La prueba de laboratorio no puede ser nulo");
            }





            mascota mascota = buscarMascota.get();
            Laboratorio laboratorio= buscarXnombre.get();
            veterinario veterinario = buscarVeterinario.get();


            citaLaboratorios.setMascota(mascota);
            citaLaboratorios.setLaboratorio(laboratorio);
            citaLaboratorios.setVeterinario(veterinario);


            cita_laboratorio nuevaCita = repo.save(citaLaboratorios);

            if (nuevaCita != null) {
                return  nuevaCita;
            } else {
                throw new RuntimeException("cita no a sido programada");
            }
        } catch (Exception e) {

            System.out.println("error " +e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public cita_laboratorio modificarCitaLabora(int idCitaLabora, cita_laboratorio citaLaboratorio) {
        return null;
    }
}
