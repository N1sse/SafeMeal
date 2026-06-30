package com.ucr.smas.service;

import com.ucr.smas.model.PlanComidas;
import com.ucr.smas.model.Padecimiento;
import com.ucr.smas.model.User;
import com.ucr.smas.model.dto.PlanComidasDTO;
import com.ucr.smas.repository.PlanComidasJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public PlanComidasService() {
    }

    public List<PlanComidas> findAll(){
        return repository.findAll();
    }

    public PlanComidas getPlanById(Integer id){
        Optional<PlanComidas> planComidasExists = repository.findById(id);
        if (planComidasExists.isPresent()) {
            return planComidasExists.get();
        }
        return null;

    }

    public PlanComidas addPlan(PlanComidasDTO menu){
        if(!repository.existsByPlanName(menu.getPlanName())){
            User user = userService.getById(menu.getUserId());
            if(user==null){
                return null;
            }
            Padecimiento padecimientos = padecimientoService.getById(menu.getPadecimientoId());
            if(padecimientos==null){
                return null;
            }
            PlanComidas planComidasTemp = new PlanComidas();
            planComidasTemp.setPlanName(menu.getPlanName());
            planComidasTemp.setFood(menu.getFood());
            planComidasTemp.setDescription(menu.getDescription());
            planComidasTemp.setUser(user);
            planComidasTemp.setPadecimientosId(padecimientos);
            return repository.save(planComidasTemp);

        }
        return null;
    }

    public PlanComidas updatePlan(Integer id, PlanComidas planComidas){

        Optional<PlanComidas> planComidasExists = repository.findById(id);
        if (planComidasExists.isPresent()){
            PlanComidas planComidasTemp = planComidasExists.get();
            if (!planComidasTemp.getPlanName().isEmpty()){
                planComidasTemp.setPlanName(planComidas.getPlanName());
            }

            if (!planComidasTemp.getFood().isEmpty()){
                planComidasTemp.setFood(planComidas.getFood());
            }

            if (!planComidasTemp.getDescription().isEmpty()){
                planComidasTemp.setDescription(planComidas.getDescription());
            }

            return repository.save(planComidasTemp);
        }

        return null;
    }

    public PlanComidas deletePlan(Integer id) {
        Optional<PlanComidas> planComidasExists = repository.findById(id);
        if (planComidasExists.isPresent()) {
            repository.deleteById(id);
            return planComidasExists.get();
        }
        return null;

    }

    public PlanComidas getByName(String name){
        if (repository.existsByPlanName(name)){
            return repository.getByPlanName(name);
        }
        return null;
    }


}
