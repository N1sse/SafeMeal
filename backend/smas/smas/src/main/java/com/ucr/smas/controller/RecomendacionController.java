package com.ucr.smas.controller;

import com.ucr.smas.model.dto.RecomendationResponseDTO;
import com.ucr.smas.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @GetMapping("/{userId}")
    public ResponseEntity<RecomendationResponseDTO> obtenerRecomendaciones(
            @PathVariable Integer userId) {

        RecomendationResponseDTO response =
                recomendacionService.obtenerRecomendaciones(userId);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }
}

