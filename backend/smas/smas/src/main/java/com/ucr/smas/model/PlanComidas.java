package com.ucr.smas.model;




import jakarta.persistence.*;
import org.hibernate.engine.spi.Status;

@Entity
@Table(name="tb-planComidas")
public class PlanComidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String planName;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
   @JoinColumn(name="padecimientos_id")
    private Padecimiento padecimientos;
    private String food;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status nivelRecomendacion;

    public PlanComidas() {
    }


    public PlanComidas(Integer id, String planName, User user, String food, String description, Status nivelRecomendacion) {
        this.id = id;
        this.planName = planName;
        this.user = user;
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

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Padecimiento getPadecimientos() {return padecimientos;}

    public void setPadecimientosId(Padecimiento padecimientos) {
            this.padecimientos = padecimientos;
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

    public void setPadecimientos(Padecimiento padecimientos) {
        this.padecimientos = padecimientos;
    }

    public Status getNivelRecomendacion() {
        return nivelRecomendacion;
    }

    public void setNivelRecomendacion(Status nivelRecomendacion) {
        this.nivelRecomendacion = nivelRecomendacion;
    }
}
