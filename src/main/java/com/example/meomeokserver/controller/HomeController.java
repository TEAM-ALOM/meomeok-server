package com.example.meomeokserver.controller;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.dto.FilterDTO;
import com.example.meomeokserver.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/")
    public String home(Model model) {
        List<FilterDTO> filterList = filterService.findAll();
        model.addAttribute("filterList", filterList);
        return "home";
    }

    @PostMapping("/menu")
    public String selectedFilters(@RequestParam(value = "seletedFilters", required = false) List<Filter> selectedFilters, Model model) {

        model.addAttribute("selectedFilters", selectedFilters);
        return "menu";
    }
}
