package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Menu;
import com.HotelAndRest.springProject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // GET: /menus
    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    // GET: /menus/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") int dishId) {
        Menu menu = menuService.getMenuById(dishId);
        if (menu != null) {
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /menus
    @PostMapping
    public ResponseEntity<String> addMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
        return new ResponseEntity<>("Menu item added successfully.", HttpStatus.CREATED);
    }

    // PUT: /menus/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMenu(@PathVariable("id") int dishId, @RequestBody Menu menu) {
        menu.setDishId(dishId);
        menuService.updateMenu(menu);
        return new ResponseEntity<>("Menu item updated successfully.", HttpStatus.OK);
    }

    // DELETE: /menus/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") int dishId) {
        menuService.deleteMenu(dishId);
        return new ResponseEntity<>("Menu item deleted successfully.", HttpStatus.OK);
    }
}
