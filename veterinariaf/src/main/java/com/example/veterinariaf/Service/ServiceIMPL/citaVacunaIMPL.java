package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.citaVacunaService;
import com.example.veterinariaf.entity.*;
import com.example.veterinariaf.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class citaVacunaIMPL implements citaVacunaService {


    private final citaVacunasRepo repo;
    private final mascotaRepo repoMas;

    private final veterinarioRepo repoVete;

    private final vacunasRepo repoVacu;

    @Autowired

    public citaVacunaIMPL(citaVacunasRepo repo,mascotaRepo repoMas,veterinarioRepo repoVete, vacunasRepo repoVacu){
        this.repo=repo;
        this.repoMas=repoMas;
        this.repoVete=repoVete;
        this.repoVacu=repoVacu;
    }


    @Override
    public List<citaVacunaDTo> listarCitasVacunas() {
        List<Object[]> resultado=this.repo.listarCitasVacunas();
        List<citaVacunaDTo> citaVacunaDToList=new ArrayList<>();

        for (Object[] resultados:resultado){
            citaVacunaDToList.add(new citaVacunaDTo(
                    (Date) resultados[0],
                    (Time) resultados[1],
                    (String)resultados[2],
                    (String)resultados[3],
                    (String) resultados[4]
            ));
        }
        return citaVacunaDToList;
    }

    @Override
    public cita_vacunas crearCitaVacuna(cita_vacunas citaVacuna, String nombre, String nombreVa, String nombreV) {
        try {

            Optional<mascota> buscarMascota = Optional.ofNullable(repoMas.buscarXnombre(nombre));
            if (!buscarMascota.isPresent()) {
                throw new RuntimeException("no se encontro la mascota");
            }


            Optional<veterinario> buscarVeterinario = Optional.ofNullable(repoVete.buscarPorNombre(nombreV));
            if (!buscarVeterinario.isPresent()) {
                throw new RuntimeException("veterinario no encontrado");
            }

            Optional<vacunas> buscarXnombre= Optional.ofNullable(this.repoVacu.buscarXnombre(nombreVa));

            if (!buscarXnombre.isPresent()) {

                throw new RuntimeException("La prueba de laboratorio no puede ser nulo");
            }





            mascota mascota = buscarMascota.get();
            vacunas vacunas=buscarXnombre.get();
            veterinario veterinario = buscarVeterinario.get();


            citaVacuna.setMascota(mascota);
            citaVacuna.setVacunas(vacunas);
            citaVacuna.setVeterinario(veterinario);


            cita_vacunas nuevaCita = this.repo.save(citaVacuna);

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
    public cita_vacunas modificarCitaVacuna(int idCitaVacuna, cita_vacunas citaVacuna) {
        return null;
    }
}
