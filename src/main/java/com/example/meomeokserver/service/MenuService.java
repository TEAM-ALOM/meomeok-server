package com.example.meomeokserver.service;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import com.example.meomeokserver.dto.MenuDTO;
import com.example.meomeokserver.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Optional<MenuDTO> findRandomMenu(List<Filter> filters) {
        List<Menu> menuList = menuRepository.findByFiltersContains(filters);

        if (!menuList.isEmpty()) {
            int randomIndex = (new Random()).nextInt(menuList.size());
            Menu randomMenu = menuList.get(randomIndex);

            MenuDTO menuDTO = new MenuDTO(randomMenu.getId(), randomMenu.getName());

            return Optional.of(menuDTO);
        }

        return Optional.empty();
    }
}
