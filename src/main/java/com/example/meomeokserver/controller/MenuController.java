package com.example.meomeokserver.controller;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.dto.MenuDTO;
import com.example.meomeokserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public String showMenu(@RequestParam(value = "selectedFilters", required = false) List<Filter> selectedFilters, Model model) {

        Optional<MenuDTO> resultMenuDTO = menuService.findRandomMenu(selectedFilters);
        model.addAttribute("resultMenu", resultMenuDTO);

        return "result";
    }
}
