package com.ucr.smas.controller;

import com.ucr.smas.model.Alimento;
import com.ucr.smas.model.dto.AlimentoRequestDTO;
import com.ucr.smas.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
@CrossOrigin(origins = "*")
public class AlimentoController {

    @Autowired
    private AlimentoService service;

    @GetMapping("/all")
    public ResponseEntity<List<?>> getAll() {
        List<Alimento> alimentos = service.findAll();
        if (!alimentos.isEmpty()) {
            return ResponseEntity.ok(alimentos);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Alimento alimento = service.getById(id);
        if (alimento == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alimento con ese ID no existe.");
        }
        return ResponseEntity.ok(alimento);
    }

    @GetMapping("/porPadecimiento/{padecimientoId}")
    public ResponseEntity<?> getByPadecimiento(@PathVariable Integer padecimientoId) {
        List<Alimento> alimentos = service.getByPadecimiento(padecimientoId);
        if (alimentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alimentos);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AlimentoRequestDTO alimentoRequest) {
        Alimento resultado = service.add(alimentoRequest);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo registrar el alimento. Verifique que el padecimiento exista.");
        }
        return ResponseEntity.ok("El alimento se registró con éxito");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody AlimentoRequestDTO dto) {
        Alimento resultado = service.update(id, dto);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alimento con ese ID no existe.");
        }
        return ResponseEntity.ok("El alimento se actualizó con éxito");
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (service.getById (id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alimento con ese ID no existe.");
        }
        service.delete(id);
        return ResponseEntity.ok("Alimento borrado con éxito");
    }
}

