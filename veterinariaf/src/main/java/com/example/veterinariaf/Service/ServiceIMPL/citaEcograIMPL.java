package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.citaEcografiaService;
import com.example.veterinariaf.entity.*;
import com.example.veterinariaf.repositorio.citaEcografiaRepo;
import com.example.veterinariaf.repositorio.ecografiaRepo;
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
public class citaEcograIMPL implements citaEcografiaService {

    private final citaEcografiaRepo repo;
    private final mascotaRepo repoMas;

    private final veterinarioRepo repoVete;

    private final ecografiaRepo repoEco;

    @Autowired

    public citaEcograIMPL(citaEcografiaRepo repo,mascotaRepo repoMas,veterinarioRepo repoVete, ecografiaRepo repoEco){
        this.repo=repo;
        this.repoMas=repoMas;
        this.repoVete=repoVete;
        this.repoEco=repoEco;
    }



    @Override
    public List<citaEcografiaDTo> listarCitaEcogra() {
        List<Object[]> resultados= this.repo.listarCitaEcogra();
        List<citaEcografiaDTo> citaEcografiaDTos=new ArrayList<>();

        for (Object [] resultado : resultados){
            citaEcografiaDTos.add(new citaEcografiaDTo(
                    (Date) resultado[0],
                    (Time) resultado[1],
                    (String)resultado[2],
                    (String)resultado[3],
                    (String) resultado[4]
                    )
            );
        }
        return  citaEcografiaDTos;
    }

    @Override
    public cita_ecografia crearCitaEcogra(cita_ecografia citaEcografia, String nombre, String nombreE, String nombreV) {
        try {

            Optional<mascota> buscarMascota = Optional.ofNullable(repoMas.buscarXnombre(nombre));
            if (!buscarMascota.isPresent()) {
                throw new RuntimeException("no se encontro la mascota");
            }


            Optional<veterinario> buscarVeterinario = Optional.ofNullable(repoVete.buscarPorNombre(nombreV));
            if (!buscarVeterinario.isPresent()) {
                throw new RuntimeException("veterinario no encontrado");
            }

            Optional<ecografia> buscarXnombre= Optional.ofNullable(this.repoEco.buscarXnombre(nombreE));

            if (!buscarXnombre.isPresent()) {

                throw new RuntimeException("La prueba de laboratorio no puede ser nulo");
            }

            mascota mascota = buscarMascota.get();
            ecografia ecografia=buscarXnombre.get();
            veterinario veterinario = buscarVeterinario.get();


            citaEcografia.setMascota(mascota);
            citaEcografia.setEcografia(ecografia);
            citaEcografia.setVeterinario(veterinario);


            cita_ecografia nuevaCita = this.repo.save(citaEcografia);

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
    public cita_ecografia modificarCitaEcogra(int id_ecografia, cita_ecografia citaEcografia) {

         try {

           Optional<cita_ecografia> buscarCita=this.repo.findById(id_ecografia);
           if (buscarCita!=null){

            cita_ecografia citaencontra=buscarCita.get();
            citaencontra.setFechaCita(citaEcografia.getFechaCita());
            citaencontra.setHora(citaEcografia.getHora());

            cita_ecografia ecografiaModificada=this.repo.save(citaencontra);

            if (ecografiaModificada!=null){
              return  ecografiaModificada;
            }else {
              throw new RuntimeException("error al modificar");
            }
           }

         }catch (Exception e){
           System.out.println("error al modificar la cita" +e);
         }
         return null;
    }

  @Override
  public cita_ecografia buscarCita(int idEcografia) {
      try {
        cita_ecografia buscarCita = this.repo.findById(idEcografia).get();

        if (buscarCita!=null){
          return buscarCita;
        }else {
          throw new RuntimeException("no se encontro cita");
        }
      }catch (Exception e){
        System.out.println("error al buscar" +e);
      }
      return null;
  }
}
