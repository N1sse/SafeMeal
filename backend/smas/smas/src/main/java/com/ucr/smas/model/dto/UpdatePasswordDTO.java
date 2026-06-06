package com.ucr.smas.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdatePasswordDTO {

    @NotBlank(message = "Por favor, ingrese la nueva contraseña. Este campo es obligatorio.")
    @Size(min = 8, max = 64, message = "La nueva contraseña debe tener entre 8 y 64 caracteres.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[.,+?!*#$@%&()_\\-={}\\[\\]:;<>/]).+$",
            message = "La nueva contraseña debe incluir al menos una minúscula, una mayúscula, un número y un carácter especial."
    )
    private String password;

    public UpdatePasswordDTO() {
    }

    public UpdatePasswordDTO( String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
