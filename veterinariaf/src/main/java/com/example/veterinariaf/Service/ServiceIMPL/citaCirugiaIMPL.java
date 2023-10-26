package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.citaCirugiaService;
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
public class citaCirugiaIMPL implements citaCirugiaService {

  private final citaCirugiaRepo repo;
  private final mascotaRepo repoMas;

  private final veterinarioRepo repoVete;

  private final cirugiasRepo repoCi;

  @Autowired
  public citaCirugiaIMPL(citaCirugiaRepo repo,mascotaRepo repoMas, veterinarioRepo repoVete,cirugiasRepo repoCi){
    this.repo=repo;
    this.repoMas=repoMas;
    this.repoVete=repoVete;
    this.repoCi=repoCi;
  }

  @Override
  public List<citaCirugiaDTo> listarCitaCirugia() {
    List<Object[]> resultado=this.repo.listarCitaCirugia();
    List<citaCirugiaDTo> citaCirugiaDToList=new ArrayList<>();

    for (Object [] resulta: resultado){
      citaCirugiaDToList.add(new citaCirugiaDTo(
        (Date) resulta[0],
        (Time) resulta[1],
        (String)resulta[2],
        (String)resulta[3],
        (String) resulta[4]
      ));
    }
    return citaCirugiaDToList;
  }

  @Override
  public cita_cirugia crearCita(cita_cirugia citaCirugia, String nombre, String nombreC, String nombreV) {
    try {

      Optional<mascota> buscarMascota = Optional.ofNullable(repoMas.buscarXnombre(nombre));
      if (!buscarMascota.isPresent()) {
        throw new RuntimeException("no se encontro la mascota");
      }


      Optional<veterinario> buscarVeterinario = Optional.ofNullable(repoVete.buscarPorNombre(nombreV));
      if (!buscarVeterinario.isPresent()) {
        throw new RuntimeException("veterinario no encontrado");
      }

      Optional<cirugias> buscarXnombre= Optional.ofNullable(this.repoCi.buscarXnombre(nombreC));

      if (!buscarXnombre.isPresent()) {

        throw new RuntimeException("La prueba de laboratorio no puede ser nulo");
      }





      mascota mascota = buscarMascota.get();
      cirugias cirugias=buscarXnombre.get();
      veterinario veterinario = buscarVeterinario.get();


      citaCirugia.setMascota(mascota);
      citaCirugia.setCirugias(cirugias);
      citaCirugia.setVeterinario(veterinario);


      cita_cirugia nuevaCita = this.repo.save(citaCirugia);

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
  public cita_cirugia modificarCita(int idCitaCirugia, cita_cirugia citaCirugia) {
    return null;
  }

  @Override
  public cita_cirugia buscarCitaCirugia(int idCitaCirugia) {
    return null;
  }
}
