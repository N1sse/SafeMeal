package com.ucr.smas.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginDTO {
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

    public LoginDTO() {
    }

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
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
}
