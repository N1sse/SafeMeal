package com.ucr.smas.model.dto;

public class AlimentoDTO {

    private String nombre;
    private String razon;

    public AlimentoDTO() {
    }

    public AlimentoDTO(String nombre, String razon) {
        this.nombre = nombre;
        this.razon = razon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
