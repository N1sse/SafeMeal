package com.ucr.smas.model.dto;

import java.util.List;

public class RecomendationResponseDTO {
    //nombre de los padecimientos
    private List<String> padecimientos;

    // Nivel de riesgo de consumir un Alimento
    private List<AlimentoDTO> recomendados;
    private List<AlimentoDTO> precaucion;
    private List<AlimentoDTO> evitar;

    //Ejemplo de platillo - comidas con esos alimentos
    private List<String> platillos;

    //metodos contructores
    public RecomendationResponseDTO() {
    }

    public List<String> getPadecimientos() {
        return padecimientos;
    }

    //set y gets
    public void setPadecimientos(List<String> padecimientos) {
        this.padecimientos = padecimientos;
    }

    public List<AlimentoDTO> getRecomendados() {
        return recomendados;
    }

    public void setRecomendados(List<AlimentoDTO> recomendados) {
        this.recomendados = recomendados;
    }

    public List<AlimentoDTO> getPrecaucion() {
        return precaucion;
    }

    public void setPrecaucion(List<AlimentoDTO> precaucion) {
        this.precaucion = precaucion;
    }

    public List<AlimentoDTO> getEvitar() {
        return evitar;
    }

    public void setEvitar(List<AlimentoDTO> evitar) {
        this.evitar = evitar;
    }

    public List<String> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<String> platillos) {
        this.platillos = platillos;
    }
}
