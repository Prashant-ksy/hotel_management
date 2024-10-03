package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Menu;
import com.HotelAndRest.springProject.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Add a new menu item
    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    // Get all menu items
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    // Get menu item by dish ID
    public Menu getMenuById(int dishId) {
        return menuRepository.findById(dishId);
    }

    // Update menu item
    public void updateMenu(Menu menu) {
        menuRepository.update(menu);
    }

    // Delete menu item by dish ID
    public void deleteMenu(int dishId) {
        menuRepository.delete(dishId);
    }
}
