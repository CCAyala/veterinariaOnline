package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.citaServicioService;
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
public class citaServicioIMPL implements citaServicioService {

    private final citaServicioRepo repo;
    private final mascotaRepo repoMas;

    private final veterinarioRepo repoVete;

    private final servicioRepo repoSer;

    @Autowired
    public citaServicioIMPL(citaServicioRepo repo, mascotaRepo repoMas, veterinarioRepo repoVete, servicioRepo repoSer){
        this.repo=repo;
        this.repoMas=repoMas;
        this.repoVete=repoVete;
        this.repoSer=repoSer;
    }


    @Override
    public List<citaServicioDTO> listadeCitaSevicio() {
        List<Object []> resultado= this.repo.listadeCitaSevicio();
        List<citaServicioDTO>  citaServicioDTOList=new ArrayList<>();

        for (Object[] resul: resultado){
            citaServicioDTOList.add(new citaServicioDTO(
                    (Date) resul[0],
                    (Time) resul[1],
                    (String)resul[2],
                    (String)resul[3],
                    (String) resul[4]
            ));
        }
        return citaServicioDTOList;
    }

    @Override
    public cita_servicio crearCita(cita_servicio citaServicio, String nombre, String nombreSe, String nombreV) {
        try {

            Optional<mascota> buscarMascota = Optional.ofNullable(repoMas.buscarXnombre(nombre));
            if (!buscarMascota.isPresent()) {
                throw new RuntimeException("no se encontro la mascota");
            }


            Optional<veterinario> buscarVeterinario = Optional.ofNullable(repoVete.buscarPorNombre(nombreV));
            if (!buscarVeterinario.isPresent()) {
                throw new RuntimeException("veterinario no encontrad");
            }

            Optional<servicios> buscarXnombre= Optional.ofNullable(this.repoSer.buscarXnombre(nombreSe));

            if (!buscarXnombre.isPresent()) {

                throw new RuntimeException("La consulta medica no puede ser nulo");
            }





            mascota mascota = buscarMascota.get();
            servicios servicios=buscarXnombre.get();
            veterinario veterinario = buscarVeterinario.get();

            citaServicio.setMascota(mascota);
            citaServicio.setServicios(servicios);
            citaServicio.setVeterinario(veterinario);


            cita_servicio nuevaCita = this.repo.save(citaServicio);

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
    public cita_servicio modificarCita(int idCitaServi, cita_servicio citaServicio) {
        return null;
    }
}
