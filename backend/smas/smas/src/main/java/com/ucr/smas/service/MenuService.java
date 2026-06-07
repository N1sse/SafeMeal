package com.ucr.smas.service;

import com.ucr.smas.model.Menu;
import com.ucr.smas.model.Padecimiento;
import com.ucr.smas.model.User;
import com.ucr.smas.model.dto.MenuDTO;
import com.ucr.smas.repository.MenuJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.getById(id);
    }

    public Menu addMenu(MenuDTO menu){

        User user= userService.getById(menu.getUserId());
        Padecimiento padecimientos= padecimientoService.getById(menu.getPadecimientoId());
        Menu menuTemp= new Menu();
        menuTemp.setMenuName(menu.getMenuName());
        menuTemp.setFood(menu.getFood());
        menuTemp.setDescription(menu.getDescription());
        menuTemp.setUser(user);
        menuTemp.setPadecimientosId(padecimientos);
        return repository.save(menuTemp);

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
        } else {
            return null;
        }
    }
}
