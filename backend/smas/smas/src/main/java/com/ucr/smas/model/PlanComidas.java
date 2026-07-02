package com.ucr.smas.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb-plancomidas")
public class PlanComidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "padecimientos_id")
    private Padecimiento padecimientos;

    public PlanComidas() {
    }

    public PlanComidas(Integer id, User user, Padecimiento padecimientos) {
        this.id = id;
        this.user = user;
        this.padecimientos = padecimientos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Padecimiento getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(Padecimiento padecimientos) {
        this.padecimientos = padecimientos;
    }

    public void setPadecimientosId(Padecimiento padecimientos) {
        this.padecimientos = padecimientos;
    }
}
