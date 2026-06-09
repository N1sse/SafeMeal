package com.ucr.smas.service;

import com.ucr.smas.model.User;
import com.ucr.smas.model.dto.LoginDTO;
import com.ucr.smas.model.dto.UpdatePasswordDTO;
import com.ucr.smas.model.dto.UserDTO;
import com.ucr.smas.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserJpaRepository userRepository;

    //---Encontrar todos los usuarios
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //---Encontrar el usuario por el Id
    public User getById(Integer id){

        Optional<User> userExists= userRepository.findById(id);
        if(userExists.isPresent()){
            User userTemp = userExists.get();
            return userTemp;
        }
        return  null;
    }

    //---Guardar el usuario
    public User add(UserDTO user){
        if (userRepository.existsByEmail((user.getEmail()))){
            return null;
        }else{
            if (user.getName() == null || user.getGender() == null || user.getDateBirth() == null || user.getEmail() == null || user.getPassword() == null){
                return  null;
            }
        }
        User userTemp=new User();
        userTemp.setName(user.getName());
        userTemp.setGender(user.getGender());
        userTemp.setDateBirth(user.getDateBirth());
        userTemp.setEmail(user.getEmail());
        userTemp.setPassword(user.getPassword());
        userTemp.setRole(user.getRole());
        return userRepository.save(userTemp);
    }//fin add

    //---Actualizar el usuario
    public User updateUser(Integer id, UserDTO user){
        Optional<User> userExists = userRepository.findById(id);

        if (userExists.isPresent()){
            User userTemp = userExists.get();

            //Para poder verificar que el espacio no este en null y actulizar el nombre
            if (user.getName() != null){
                userTemp.setName(user.getName());
            }

            //Para poder verificar que el espacio no este en null y actulizar el género
            if (user.getGender() != null){
                userTemp.setGender(user.getGender());
            }

            //Para poder verificar que el espacio no este en null
            // y actulizar la fecha en la que nació el usuario
            if (user.getDateBirth()!=null){
                userTemp.setDateBirth(user.getDateBirth());
            }

            //Para poder verificar que el espacio no este en null y actulizar el email
            if (user.getEmail()!=null){
                userTemp.setEmail(user.getEmail());
            }

            //Para poder verificar que el espacio no este en null y actulizar la contraseña
            if (user.getPassword()!=null){
                userTemp.setPassword(user.getPassword());
            }

            //Para poder verificar que el espacio no este en null y actualizar el rol
            if (user.getRole()!=null){
                userTemp.setRole(user.getRole());
            }

            //Para que se guarde
            return userRepository.save(userTemp);
        }
        return null;
    }//fin updateUser

    //---Eliminar el usuario
    public User delete(Integer id){
        Optional<User> existsUser=userRepository.findById(id);

        if (existsUser.isPresent()){
            userRepository.deleteById(id);
            return existsUser.get();
        }else {
            return null;
        }
    }

    //---Para cambiar la contraseña
    public User updatePassword(String email, UpdatePasswordDTO newPassword) {
        if (email == null || newPassword == null) {
            return null;
        }

        Optional<User> userExists = userRepository.findByEmail(email);
        if (userExists.isPresent()) {
            User userTemp = userExists.get();
            userTemp.setPassword(newPassword.getPassword());
            return userRepository.save(userTemp);
        }
        return null;
    }

    //---Para poder realizar el login
    public User login(LoginDTO login) {
        Optional<User> userExists = userRepository.findByEmail(login.getEmail());

        if (userExists.isPresent()) {
            User userTemp = userExists.get();

            if (userTemp.getPassword().equals(login.getPassword())) {
                return userTemp;
            }
        }

        return null;
    }

}
