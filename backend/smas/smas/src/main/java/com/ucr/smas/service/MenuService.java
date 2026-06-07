package com.ucr.smas.service;

import com.ucr.smas.model.Menu;
import com.ucr.smas.model.Padecimiento;
import com.ucr.smas.model.User;
import com.ucr.smas.model.dto.MenuDTO;
import com.ucr.smas.repository.MenuJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private UserService userService;
   @Autowired
    private PadecimientoService padecimientoService;
    @Autowired
    private MenuJpaRepository repository;



    public MenuService() {
    }

    public List<Menu> findAll(){
        return repository.findAll();
    }

    public Menu getMenuById(Integer id){
        Optional<Menu> menuExists = repository.findById(id);
        if (menuExists.isPresent()) {
            return menuExists.get();
        }
        return null;

    }

    public Menu addMenu(MenuDTO menu){
        if(!repository.existsByMenuName(menu.getMenuName())){
            User user = userService.getById(menu.getUserId());
            if(user==null){
                return null;
            }
            Padecimiento padecimientos = padecimientoService.getById(menu.getPadecimientoId());
            if(padecimientos==null){
                return null;
            }
            Menu menuTemp = new Menu();
            menuTemp.setMenuName(menu.getMenuName());
            menuTemp.setFood(menu.getFood());
            menuTemp.setDescription(menu.getDescription());
            menuTemp.setUser(user);
            menuTemp.setPadecimientosId(padecimientos);
            return repository.save(menuTemp);

        }
        return null;
    }

    public Menu updateMenu(Integer id, Menu menu){

        Optional<Menu> menuExists = repository.findById(id);
        if (menuExists.isPresent()){
            Menu menuTemp = menuExists.get();
            if (!menuTemp.getMenuName().isEmpty()){
                menuTemp.setMenuName(menu.getMenuName());
            }

            if (!menuTemp.getFood().isEmpty()){
                menuTemp.setFood(menu.getFood());
            }

            if (!menuTemp.getDescription().isEmpty()){
                menuTemp.setDescription(menu.getDescription());
            }

            return repository.save(menuTemp);
        }

        return null;
    }

    public Menu deleteMenu(Integer id) {
        Optional<Menu> menuExists = repository.findById(id);
        if (menuExists.isPresent()) {
            repository.deleteById(id);
            return menuExists.get();
        }
        return null;

    }

    public Menu getByName(String name){
        if (repository.existsByMenuName(name)){
            return repository.getByMenuName(name);
        }
        return null;
    }


}
