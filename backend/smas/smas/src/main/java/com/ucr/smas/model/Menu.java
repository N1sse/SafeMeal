package com.ucr.smas.model;




import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="tb-menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String menuName;

    @Autowired
    @JoinColumn(name="user_id")
    private User user;
   @JoinColumn(name="padecimientos_id")
    private Padecimiento padecimientos;

    private String food;
    private String description;



    public Menu() {
    }


    public Menu(Integer id, String menuName, User user, String food, String description) {
        this.id = id;
        this.menuName = menuName;
        this.user = user;
        this.food = food;
        this.description = description;
    }
    /*
    public Menu(Integer id, String menuName,String food, String description) {
        this.id = id;
        this.menuName = menuName;
        this.food = food;
        this.description = description;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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
}
