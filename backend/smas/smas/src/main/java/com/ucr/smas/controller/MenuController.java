package com.ucr.smas.controller;

import com.ucr.smas.model.Menu;
import com.ucr.smas.model.dto.MenuDTO;
import com.ucr.smas.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("/all")
    public ResponseEntity<List<?>> getAll(){
        List<Menu> menusList = service.findAll();
        if (!menusList.isEmpty()){
            return ResponseEntity.ok(menusList);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Menu menuFound = service.getMenuById(id);
        if (menuFound==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu con ese ID no existe,");
        }
        return ResponseEntity.ok(menuFound);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addMenu(@RequestBody MenuDTO menu){
        if (service.addMenu(menu)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu se encuentra vacío o ya ha sido registrado anteriormente");
        }
        service.addMenu(menu);
        return ResponseEntity.ok("El menú se registró con éxito");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable Integer id, @RequestBody Menu menu){
        if (service.updateMenu(id, menu)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu se encuentra vacío,");
        }
        service.updateMenu(id, menu);
        return ResponseEntity.ok("El menu se actualizó con éxito");
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (service.getMenuById(id)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El menu con ese ID no existe,");
        }
        service.deleteMenu(id);
        return ResponseEntity.ok("Menu borrado con éxito");
    }

}
