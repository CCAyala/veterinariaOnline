package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.citaMedicaService;
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
public class citaMedicaIMPL implements citaMedicaService {

  private final citaMedicaRepo repo;

  private final mascotaRepo repoMas;

  private final veterinarioRepo repoVete;

  private final consultaMedicaRepo repoConsul;

  @Autowired
  public citaMedicaIMPL(citaMedicaRepo repo, mascotaRepo repoMas, veterinarioRepo repoVete, consultaMedicaRepo repoConsul){
    this.repo=repo;
    this.repoMas=repoMas;
    this.repoVete=repoVete;
    this.repoConsul=repoConsul;
  }
  @Override
  public List<citaMedicaDTo> listarCitaMedica() {
    List<Object[]> resultado=this.repo.listarCitaMedica();
    List<citaMedicaDTo> citaMedicaDToList=new ArrayList<>();

    for (Object[] resultados: resultado){
      citaMedicaDToList.add(new citaMedicaDTo(
        (Date) resultados[0],
        (Time) resultados[1],
        (String)resultados[2],
        (String)resultados[3],
        (String) resultados[4]
      ));
    }
    return citaMedicaDToList;
  }

  @Override
  public cita_medica crearCitaMedica(cita_medica citaMedica, String nombre, String nombreCo, String nombreV) {
    try {

      Optional<mascota> buscarMascota = Optional.ofNullable(repoMas.buscarXnombre(nombre));
      if (!buscarMascota.isPresent()) {
        throw new RuntimeException("no se encontro la mascota");
      }


      Optional<veterinario> buscarVeterinario = Optional.ofNullable(repoVete.buscarPorNombre(nombreV));
      if (!buscarVeterinario.isPresent()) {
        throw new RuntimeException("veterinario no encontrad");
      }

      Optional<consultaMedica> buscarXnombre= Optional.ofNullable(this.repoConsul.buscarXnombre(nombreCo));

      if (!buscarXnombre.isPresent()) {

        throw new RuntimeException("La consulta medica no puede ser nulo");
      }





      mascota mascota = buscarMascota.get();
     consultaMedica consultaMedica=buscarXnombre.get();
      veterinario veterinario = buscarVeterinario.get();

      citaMedica.setMascota(mascota);
      citaMedica.setConsultaMedica(consultaMedica);
      citaMedica.setVeterinario(veterinario);


      cita_medica nuevaCita = this.repo.save(citaMedica);

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
  public cita_medica modificaCita(int idCitaMedica, cita_medica citaMedica) {
    return null;
  }
}
