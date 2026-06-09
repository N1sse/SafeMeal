package com.ucr.smas.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserDTO {

    @NotBlank(message = "El espacio del nombre del usuario no puede ir vacío, por favor ingrese un nombre")
    private String name;

    @NotBlank(message = "El espacio del género no puede ir vacío, por favor ingrese su género")
    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Por favor ingrese la fecha de su cumpleaños")
    private LocalDate dateBirth;

    @Email(message = "Por favor, ingrese un correo electrónico válido.")
    @NotBlank(message = "El espacio del correo no puede quedar vacio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, max = 64, message = "La contraseña debe tener entre 8 y 64 caracteres.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[.,+?!*#$@%&()_\\-={}\\[\\]:;<>/]).+$",
            message = "La contraseña debe tener un mínimo de 8caracteres; otras consideraciones es que la contraseña debe de tener al menos una minúscula, una mayúscula, un número, un carácter especial."
    )
    private String password;

    @NotBlank(message = "El espacio del rol no puede quedar vacío")
    private String role;

    //metodos contructores
    public UserDTO() {
    }

    public UserDTO(String name, String gender, LocalDate dateBirth, String email, String password, String role) {
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //sets y gets
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}//fin UserDTO
