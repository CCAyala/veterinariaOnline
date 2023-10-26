package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.antecedenteService;
import com.example.veterinariaf.entity.antecedentes;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.repositorio.antecedenteRepo;
import com.example.veterinariaf.repositorio.mascotaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class antecedenteIMPL implements antecedenteService {

    private final antecedenteRepo repo;
    private final mascotaRepo repoM;

    @Autowired
    public antecedenteIMPL(antecedenteRepo repo, mascotaRepo repoM){
        this.repo=repo;
        this.repoM=repoM;
    }
    @Override
    public List<antecedentes> listarAntecendentes() {
        return (List<antecedentes>) this.repo.findAll();
    }

    @Override
    public antecedentes crearAntecedente(antecedentes antecedente) {
        mascota buscarMascota= antecedente.getMascota();
        if (buscarMascota!=null){
            Optional<mascota> optionalMascotas=this.repoM.findById(buscarMascota.getCodmasco());
            if (optionalMascotas.isPresent()){
                antecedente.setMascota(optionalMascotas.get());
                return this.repo.save(antecedente);
            }

        }else {
            System.out.println("la mascota no se ha encontrado");
        }
        return null;
    }

    @Override
    public List<antecedentes> findBymascotascod_masco(int cod_mascota) {
        return this.repo.findBymascotascod_mascotas(cod_mascota);
    }

    @Override
    public antecedentes modificarAntecedente(int cod_mascota, antecedentes antecedente) {
        List <antecedentes> buscandoAntecedente= this.repo.findBymascotascod_mascotas(cod_mascota);
        if (!buscandoAntecedente.isEmpty()){
            antecedentes antecedenteExistente = buscandoAntecedente.get(0);

            antecedenteExistente.setAlergias(antecedente.getAlergias());
            antecedenteExistente.setEstadoreproductivo(antecedente.getEstadoreproductivo());
            antecedenteExistente.setEstadocastracion(antecedente.getEstadocastracion());
            antecedenteExistente.setCirugiasanter(antecedente.getCirugiasanter());
            antecedenteExistente.setHabitad(antecedente.getHabitad());
            antecedenteExistente.setFechultidesparacitacion(antecedente.getFechultidesparacitacion());
            antecedenteExistente.setEnfermedadesante(antecedente.getEnfermedadesante());
            antecedenteExistente.setEstadoreproductivo(antecedente.getEstadoreproductivo());

            antecedentes antecedentemodificado=this.repo.save(antecedenteExistente);
            if (antecedentemodificado != null){
                System.out.println("se ha modificado con exito");
            }

        }else {
            System.out.println("no se encontro la mascota ");
        }
        return null;
    }

    @Override
    public void eliminarAntecendete(int id) {
        this.repo.deleteById(id);
    }




}
