package com.ucr.smas.model.dto;

import java.util.List;

public class PlanDetalleDTO {
    private Integer planId;
    private String planName;

    // Datos del usuario
    private Integer userId;
    private String userName;
    private String userEmail;

    // Padecimiento asociado
    private Integer padecimientoId;
    private String padecimientoNombre;
    private String padecimientoDescripcion;

    // Alimentos del catálogo, agrupados por nivel
    private List<AlimentoDTO> recomendados;
    private List<AlimentoDTO> precaucion;
    private List<AlimentoDTO> evitar;

    public PlanDetalleDTO() {
    }

    public PlanDetalleDTO(Integer planId, String planName, Integer userId, String userName, String userEmail, Integer padecimientoId, String padecimientoNombre, String padecimientoDescripcion, List<AlimentoDTO> recomendados, List<AlimentoDTO> precaucion, List<AlimentoDTO> evitar) {
        this.planId = planId;
        this.planName = planName;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.padecimientoId = padecimientoId;
        this.padecimientoNombre = padecimientoNombre;
        this.padecimientoDescripcion = padecimientoDescripcion;
        this.recomendados = recomendados;
        this.precaucion = precaucion;
        this.evitar = evitar;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getPadecimientoId() {
        return padecimientoId;
    }

    public void setPadecimientoId(Integer padecimientoId) {
        this.padecimientoId = padecimientoId;
    }

    public String getPadecimientoNombre() {
        return padecimientoNombre;
    }

    public void setPadecimientoNombre(String padecimientoNombre) {
        this.padecimientoNombre = padecimientoNombre;
    }

    public String getPadecimientoDescripcion() {
        return padecimientoDescripcion;
    }

    public void setPadecimientoDescripcion(String padecimientoDescripcion) {
        this.padecimientoDescripcion = padecimientoDescripcion;
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
}
