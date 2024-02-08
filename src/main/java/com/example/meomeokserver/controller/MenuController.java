package com.example.meomeokserver.controller;

import com.example.meomeokserver.dto.MenuDTO;
import com.example.meomeokserver.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public List<MenuDTO> shoeMenu() {

        return menuService.findAll();
    }
}
