package com.ucr.smas.service;

import com.ucr.smas.model.*;
import com.ucr.smas.model.dto.AlimentoDTO;
import com.ucr.smas.model.dto.PlanComidasDTO;
import com.ucr.smas.model.dto.PlanDetalleDTO;
import com.ucr.smas.repository.AlimentoJpaRepository;
import com.ucr.smas.repository.PlanComidasJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanComidasService {

    @Autowired
    private UserService userService;
   @Autowired
    private PadecimientoService padecimientoService;
    @Autowired
    private PlanComidasJpaRepository repository;
    @Autowired
    private AlimentoJpaRepository alimentoRepository;

    public PlanComidasService() {
    }

    public PlanComidasService(UserService userService, PadecimientoService padecimientoService, PlanComidasJpaRepository repository, AlimentoJpaRepository alimentoRepository) {
        this.userService = userService;
        this.padecimientoService = padecimientoService;
        this.repository = repository;
        this.alimentoRepository = alimentoRepository;
    }

    public List<PlanComidas> findAll() {
        return repository.findAll();
    }

    //obtner por id
    public PlanComidas getPlanById(Integer id) {
        Optional<PlanComidas> planComidasExists = repository.findById(id);
        return planComidasExists.orElse(null);
    }

    //agregar plan
    public PlanComidas addPlan(PlanComidasDTO menu) {
        User user = userService.getById(menu.getUserId());
        if (user == null) {
            return null;
        }
        Padecimiento padecimientos = padecimientoService.getById(menu.getPadecimientoId());
        if (padecimientos == null) {
            return null;
        }

        PlanComidas planComidasTemp = new PlanComidas();
        planComidasTemp.setUser(user);
        planComidasTemp.setPadecimientosId(padecimientos);

        return repository.save(planComidasTemp);
    }

    //updatePlan
    public PlanComidas updatePlan(Integer id, PlanComidasDTO planComidas) {
        Optional<PlanComidas> planComidasExists = repository.findById(id);
        if (planComidasExists.isPresent()) {
            PlanComidas planComidasTemp = planComidasExists.get();

            if (planComidas.getPadecimientoId() != null) {
                Padecimiento padecimiento = padecimientoService.getById(planComidas.getPadecimientoId());
                if (padecimiento != null) {
                    planComidasTemp.setPadecimientosId(padecimiento);
                }
            }

            return repository.save(planComidasTemp);
        }
        return null;
    }

    //Delete
    public PlanComidas deletePlan(Integer id) {
        Optional<PlanComidas> planComidasExists = repository.findById(id);
        if (planComidasExists.isPresent()) {
            repository.deleteById(id);
            return planComidasExists.get();
        }
        return null;
    }

    //obtener plan
    public PlanDetalleDTO getPlanDetalle(Integer id) {
        Optional<PlanComidas> planExists = repository.findById(id);
        if (planExists.isEmpty()) {
            return null;
        }

        PlanComidas plan = planExists.get();
        User user = plan.getUser();
        Padecimiento padecimiento = plan.getPadecimientos();

        PlanDetalleDTO detalle = new PlanDetalleDTO();
        detalle.setPlanId(plan.getId());

        // Datos del usuario
        if (user != null) {
            detalle.setUserId(user.getId());
            detalle.setUserName(user.getName());
            detalle.setUserEmail(user.getEmail());
        }

        // Datos del padecimiento
        List<AlimentoDTO> recomendados = new ArrayList<>();
        List<AlimentoDTO> precaucion = new ArrayList<>();
        List<AlimentoDTO> evitar = new ArrayList<>();

        if (padecimiento != null) {
            detalle.setPadecimientoId(padecimiento.getId());
            detalle.setPadecimientoNombre(padecimiento.getNombre());
            detalle.setPadecimientoDescripcion(padecimiento.getDescripcion());

            // Alimentos del catálogo para ese padecimiento
            List<Alimento> alimentos =
                    alimentoRepository.findByPadecimiento_Id(padecimiento.getId());

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
        }

        detalle.setRecomendados(recomendados);
        detalle.setPrecaucion(precaucion);
        detalle.setEvitar(evitar);

        return detalle;
    }
}//fin PlanComidasService
