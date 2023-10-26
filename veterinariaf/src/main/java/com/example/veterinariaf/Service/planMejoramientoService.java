package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.planMejoramiento;
import com.example.veterinariaf.entity.planMejoramientoDTO;

import java.util.List;

public interface planMejoramientoService {

  public List<planMejoramientoDTO>listarPLanMejoramiento();

  public planMejoramiento crearPlanMejoramiento(planMejoramiento planMejoramiento,int nDiagnotico, String nombreVete, String nombreMedi);
}
