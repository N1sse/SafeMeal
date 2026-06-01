package com.ucr.smas.service;

import com.ucr.smas.model.User;
import com.ucr.smas.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJpaRepository userRepository;

    //Encontrar todos los usuarios
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //Encontrar el usuario por el Id

    //Guardar el usuario

    //Actualizar el usuario

    //eliminar el usuario


}
