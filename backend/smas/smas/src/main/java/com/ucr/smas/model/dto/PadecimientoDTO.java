package com.ucr.smas.model.dto;

public class PadecimientoDTO {

    private String nombre;
    private String descripcion;

    public PadecimientoDTO() {
    }

    public PadecimientoDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}//fin DTO