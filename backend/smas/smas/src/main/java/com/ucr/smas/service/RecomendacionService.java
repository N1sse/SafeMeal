
        package com.ucr.smas.service;

import com.ucr.smas.model.PlanComidas;
import com.ucr.smas.model.nivelRecomendacion;
import com.ucr.smas.model.dto.AlimentoDTO;
import com.ucr.smas.model.dto.RecomendationResponseDTO;
import com.ucr.smas.repository.PlanComidasJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecomendacionService {

    @Autowired
    private PlanComidasJpaRepository planComidasRepository;

    public RecomendationResponseDTO obtenerRecomendaciones(Integer userId) {

        // Obtener los padecimientos asociados al usuario
        List<PlanComidas> vinculos =
                planComidasRepository.findByUser_Id(userId);

        if (vinculos.isEmpty()) {
            return null;
        }

        List<String> padecimientos = new ArrayList<>();
        List<Integer> idsPadecimientos = new ArrayList<>();

        for (PlanComidas p : vinculos) {

            padecimientos.add(
                    p.getPadecimientos().getNombre()
            );

            idsPadecimientos.add(
                    p.getPadecimientos().getId()
            );
        }

        // Obtener alimentos asociados a esos padecimientos
        List<PlanComidas> alimentos =
                planComidasRepository
                        .findByPadecimientos_IdInAndUser_IdIsNull(idsPadecimientos);

        List<AlimentoDTO> recomendados = new ArrayList<>();
        List<AlimentoDTO> precaucion = new ArrayList<>();
        List<AlimentoDTO> evitar = new ArrayList<>();

        // Clasificar alimentos según el nivel de recomendación
        for (PlanComidas alimento : alimentos) {

            AlimentoDTO dto = new AlimentoDTO(
                    alimento.getFood(),
                    alimento.getDescription()
            );

            if (alimento.getNivelRecomendacion() ==
                    nivelRecomendacion.RECOMENDADO) {

                recomendados.add(dto);

            } else if (alimento.getNivelRecomendacion() ==
                    nivelRecomendacion.PRECAUCION) {

                precaucion.add(dto);

            } else if (alimento.getNivelRecomendacion() ==
                    nivelRecomendacion.EVITAR) {

                evitar.add(dto);
            }
        }

        // Generar ejemplos de platillos
        List<String> platillos =
                generarPlatillos(recomendados);

        // Construir respuesta
        RecomendationResponseDTO response =
                new RecomendationResponseDTO();

        response.setPadecimientos(padecimientos);
        response.setRecomendados(recomendados);
        response.setPrecaucion(precaucion);
        response.setEvitar(evitar);
        response.setPlatillos(platillos);

        return response;
    }

    private List<String> generarPlatillos(
            List<AlimentoDTO> recomendados) {

        List<String> platillos = new ArrayList<>();

        if (recomendados.size() >= 2) {
            platillos.add(
                    recomendados.get(0).getNombre()
                            + " con "
                            + recomendados.get(1).getNombre()
            );
        }

        if (recomendados.size() >= 3) {
            platillos.add(
                    recomendados.get(1).getNombre()
                            + " y "
                            + recomendados.get(2).getNombre()
            );
        }

        if (recomendados.size() >= 4) {
            platillos.add(
                    recomendados.get(2).getNombre()
                            + " acompañado de "
                            + recomendados.get(3).getNombre()
            );
        }

        return platillos;
    }
}
