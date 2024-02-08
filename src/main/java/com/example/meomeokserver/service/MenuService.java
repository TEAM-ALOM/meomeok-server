package com.example.meomeokserver.service;

import com.example.meomeokserver.domain.Menu;
import com.example.meomeokserver.dto.FilterDTO;
import com.example.meomeokserver.dto.MenuDTO;
import com.example.meomeokserver.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuDTO> findAll() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MenuDTO convertToDTO(Menu menu) {
        return new MenuDTO(
                menu.getId(),
                menu.getName(),
                menu.getFilters().stream()
                        .map(filter -> new FilterDTO(filter.getId(), filter.getName()))
                        .collect(Collectors.toSet())
        );
    }
}
