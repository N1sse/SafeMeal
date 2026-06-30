package com.ucr.smas.model.dto;
import jakarta.persistence.*;
import org.hibernate.engine.spi.Status;

public class PlanComidasDTO {


    private String planName;

    private Integer userId;

    private Integer padecimientoId;

    private String food;

    private String description;

    private Status nivelRecomendacion;

    private String platilloEjemplo;

    private String image;


    public String getPlanName() {
        return planName;
    }

    public void setMenuName(String planName) {
        this.planName = planName;
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
