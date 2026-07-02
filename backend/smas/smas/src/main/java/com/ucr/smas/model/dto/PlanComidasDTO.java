package com.ucr.smas.model.dto;
import jakarta.persistence.*;
import org.hibernate.engine.spi.Status;
import com.ucr.smas.model.nivelRecomendacion;

public class PlanComidasDTO {

    private Integer userId;
    private Integer padecimientoId;

    public PlanComidasDTO() {
    }

    public PlanComidasDTO(Integer userId, Integer padecimientoId) {
        this.userId = userId;
        this.padecimientoId = padecimientoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPadecimientoId() {
        return padecimientoId;
    }

    public void setPadecimientoId(Integer padecimientoId) {
        this.padecimientoId = padecimientoId;
    }

}