package com.ucr.smas.model.dto;

import com.ucr.smas.model.nivelRecomendacion;

public class AlimentoRequestDTO {

    private Integer padecimientoId;
    private String food;
    private String description;
    private nivelRecomendacion nivelRecomendacion;

    public AlimentoRequestDTO() {
    }

    public AlimentoRequestDTO(Integer padecimientoId, String food, String description, nivelRecomendacion nivelRecomendacion) {
        this.padecimientoId = padecimientoId;
        this.food = food;
        this.description = description;
        this.nivelRecomendacion = nivelRecomendacion;
    }

    public Integer getPadecimientoId() {
        return padecimientoId;
    }

    public void setPadecimientoId(Integer padecimientoId) {
        this.padecimientoId = padecimientoId;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public nivelRecomendacion getNivelRecomendacion() {
        return nivelRecomendacion;
    }

    public void setNivelRecomendacion(nivelRecomendacion nivelRecomendacion) {
        this.nivelRecomendacion = nivelRecomendacion;
    }
}

