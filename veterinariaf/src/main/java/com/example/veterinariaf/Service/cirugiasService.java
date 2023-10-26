package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.cirugias;

import java.util.List;

public interface cirugiasService {

  public List<cirugias> listarCirugias();

  public  cirugias crearCirugia( cirugias cirugia);

  public cirugias modificarCirugia(int idCirugia, cirugias cirugia);

  public  cirugias buscarCirugia(int idCirugia);
}
