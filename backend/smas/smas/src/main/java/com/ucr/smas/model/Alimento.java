package com.ucr.smas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb-alimentos")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "padecimiento_id")
    private Padecimiento padecimiento;

    private String food;

    private String description;

    @Enumerated(EnumType.STRING)
    private nivelRecomendacion nivelRecomendacion;

    public Alimento() {
    }

    public Alimento(Integer id, Padecimiento padecimiento, String food,
                    String description, nivelRecomendacion nivelRecomendacion) {
        this.id = id;
        this.padecimiento = padecimiento;
        this.food = food;
        this.description = description;
        this.nivelRecomendacion = nivelRecomendacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Padecimiento getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(Padecimiento padecimiento) {
        this.padecimiento = padecimiento;
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

