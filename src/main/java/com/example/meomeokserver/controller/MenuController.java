package com.example.meomeokserver.controller;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.dto.MenuDTO;
import com.example.meomeokserver.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api/v1/meomeok")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public Optional<MenuDTO> showMenu(@RequestParam(value = "selectedFilters", required = false) List<Filter> selectedFilters) {

        return menuService.findRandomMenu(selectedFilters);
    }
}
