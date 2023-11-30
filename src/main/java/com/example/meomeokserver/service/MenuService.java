package com.example.meomeokserver.service;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import com.example.meomeokserver.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Optional<Menu> getResultMenu(List<Filter> selectFilters) {
        return menuRepository.findRandomMenuByFilterListIn(selectFilters);
    }
}
