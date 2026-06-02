package com.ucr.smas.controller;

import com.ucr.smas.model.Padecimiento;
import com.ucr.smas.service.PadecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/padecimientos")
public class PadecimientoController {

    @Autowired
    private PadecimientoService service;

    @GetMapping("/all")
    public ResponseEntity<List<?>> getAll() {

        List<Padecimiento> padecimientos = service.findAll();

        if (padecimientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(padecimientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {

        Padecimiento padecimiento = service.getById(id);

        if (padecimiento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(padecimiento);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Padecimiento padecimiento) {

        if (service.add(padecimiento) == null) {
            return ResponseEntity.badRequest().body("El padecimiento ya existe");
        }

        return ResponseEntity.ok("Padecimiento registrado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Padecimiento padecimiento) {

        padecimiento.setId(id);

        if (service.update(padecimiento) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Padecimiento actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        if (service.delete(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Padecimiento eliminado exitosamente");
    }
}