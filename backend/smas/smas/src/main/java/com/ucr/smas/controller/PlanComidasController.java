package com.ucr.smas.controller;

import com.ucr.smas.model.PlanComidas;
import com.ucr.smas.model.dto.PlanComidasDTO;
import com.ucr.smas.service.PlanComidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planComidas")
public class PlanComidasController {

    @Autowired
    private PlanComidasService service;

    @GetMapping("/all")
    public ResponseEntity<List<?>> getAll(){
        List<PlanComidas> planComidasList = service.findAll();
        if (!planComidasList.isEmpty()){
            return ResponseEntity.ok(planComidasList);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        PlanComidas planComidasFound = service.getPlanById(id);
        if (planComidasFound ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu con ese ID no existe,");
        }
        return ResponseEntity.ok(planComidasFound);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addPlan(@RequestBody PlanComidasDTO menu){
        if (service.addPlan(menu)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu se encuentra vacío o ya ha sido registrado anteriormente");
        }
        service.addPlan(menu);
        return ResponseEntity.ok("El menú se registró con éxito");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePlan(@PathVariable Integer id, @RequestBody PlanComidas planComidas){
        if (service.updatePlan(id, planComidas)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu se encuentra vacío,");
        }
        service.updatePlan(id, planComidas);
        return ResponseEntity.ok("El menu se actualizó con éxito");
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (service.getPlanById(id)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu con ese ID no existe,");
        }
        service.deletePlan(id);
        return ResponseEntity.ok("Menu borrado con éxito");
    }

}
