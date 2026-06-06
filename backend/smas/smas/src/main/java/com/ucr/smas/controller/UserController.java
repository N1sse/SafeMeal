package com.ucr.smas.controller;

import com.ucr.smas.model.User;
import com.ucr.smas.model.dto.UpdatePasswordDTO;
import com.ucr.smas.model.dto.UserDTO;
import com.ucr.smas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    //---Get - All
    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll(){
        List<User> users = service.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    //--- Get by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        User user = service.getById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


    //---post - add the user
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors =new ArrayList<>();
            for (ObjectError error: result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        if (service.add(user) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya está registrado o faltan campos obligatorios");

        }
        return ResponseEntity.ok("El usuario fue registrado de forma exitosa");
    }


    //---Put by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @Valid @RequestBody UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errors);
        }

        User updatedUser = service.updateUser(id, user);

        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un usuario con ese id");
        }

        return ResponseEntity.ok("El usuario  fue actualizado de forma exitosa");
    }

    //---Delete by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        if (service.delete(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

    //---Para cambiar la contraseña
    @PatchMapping("/change/{email}")
    public ResponseEntity<?> changePassword(@PathVariable String email, @Valid @RequestBody UpdatePasswordDTO updatePassword, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        User updatedUser = service.updatePassword(email, updatePassword.getPassword());

        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Contraseña actualizada exitosamente");
    }

}
