
        package com.ucr.smas.service;

import com.ucr.smas.model.Alimento;
import com.ucr.smas.model.PlanComidas;
import com.ucr.smas.model.nivelRecomendacion;
import com.ucr.smas.model.dto.AlimentoDTO;
import com.ucr.smas.model.dto.RecomendationResponseDTO;
import com.ucr.smas.repository.AlimentoJpaRepository;
import com.ucr.smas.repository.PlanComidasJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecomendacionService {

    @Autowired
    private PlanComidasJpaRepository planComidasRepository;

    @Autowired
    private AlimentoJpaRepository alimentoRepository;

    public RecomendationResponseDTO obtenerRecomendaciones(Integer userId) {

        //usuario y sus padecimientos.
        List<PlanComidas> planes = planComidasRepository.findByUser_Id(userId);

        if (planes.isEmpty()) {
            return null;
        }

        List<String> padecimientos = new ArrayList<>();
        List<Integer> idsPadecimientos = new ArrayList<>();

        for (PlanComidas plan : planes) {
            padecimientos.add(plan.getPadecimientos().getNombre());
            idsPadecimientos.add(plan.getPadecimientos().getId());
        }

        // Alimentos relacionados a los padecimientos
        List<Alimento> alimentos =
                alimentoRepository.findByPadecimiento_IdIn(idsPadecimientos);

        List<AlimentoDTO> recomendados = new ArrayList<>();
        List<AlimentoDTO> precaucion = new ArrayList<>();
        List<AlimentoDTO> evitar = new ArrayList<>();

        //nivel de recomendación.
        for (Alimento alimento : alimentos) {
            AlimentoDTO dto = new AlimentoDTO(
                    alimento.getFood(),
                    alimento.getDescription()
            );

            if (alimento.getNivelRecomendacion() == nivelRecomendacion.RECOMENDADO) {
                recomendados.add(dto);
            } else if (alimento.getNivelRecomendacion() == nivelRecomendacion.PRECAUCION) {
                precaucion.add(dto);
            } else if (alimento.getNivelRecomendacion() == nivelRecomendacion.EVITAR) {
                evitar.add(dto);
            }
        }

        //ejemplos de platillos con los alimentos recomendados.
        List<String> platillos = generarPlatillos(recomendados);

        //Generar respuestas
        RecomendationResponseDTO response = new RecomendationResponseDTO();
        response.setPadecimientos(padecimientos);
        response.setRecomendados(recomendados);
        response.setPrecaucion(precaucion);
        response.setEvitar(evitar);
        response.setPlatillos(platillos);

        return response;
    }

    private List<String> generarPlatillos(List<AlimentoDTO> recomendados) {
        List<String> platillos = new ArrayList<>();

        if (recomendados.size() >= 2) {
            platillos.add(recomendados.get(0).getNombre()
                    + " con " + recomendados.get(1).getNombre());
        }
        if (recomendados.size() >= 3) {
            platillos.add(recomendados.get(1).getNombre()
                    + " y " + recomendados.get(2).getNombre());
        }
        if (recomendados.size() >= 4) {
            platillos.add(recomendados.get(2).getNombre()
                    + " acompañado de " + recomendados.get(3).getNombre());
        }

        return platillos;
    }
}
