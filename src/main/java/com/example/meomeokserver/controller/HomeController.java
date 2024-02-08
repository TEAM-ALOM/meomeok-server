package com.example.meomeokserver.controller;

import com.example.meomeokserver.dto.FilterDTO;
import com.example.meomeokserver.service.FilterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private final FilterService filterService;

    public HomeController(FilterService filterService) {
        this.filterService = filterService;
    }

    @GetMapping("/")
    public List<FilterDTO> home() {

        return filterService.findAll();
    }
}
