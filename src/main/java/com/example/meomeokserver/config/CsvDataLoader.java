package com.example.meomeokserver.config;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import com.example.meomeokserver.repository.FilterRepository;
import com.example.meomeokserver.repository.MenuRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Configuration
public class CsvDataLoader {

    private final ResourceLoader resourceLoader;
    private final MenuRepository menuRepository;
    private final FilterRepository filterRepository;

    public CsvDataLoader(ResourceLoader resourceLoader, MenuRepository menuRepository, FilterRepository filterRepository) {
        this.resourceLoader = resourceLoader;
        this.menuRepository = menuRepository;
        this.filterRepository = filterRepository;
    }

    public void loadCsvData() {
        loadMenuData();
        loadFilterData();
    }

    private void loadMenuData() {
        Resource menuCsvResource = resourceLoader.getResource("classpath:menu_data.csv");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(menuCsvResource.getInputStream()))){
            reader.readLine();
            String line;

            while((line = reader.readLine())!=null) {
                String menuName = line.trim();

                if (!menuRepository.existsByName(menuName)) {
                    Menu menu = new Menu();
                    menu.setName(menuName);
                    menuRepository.save(menu);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFilterData() {
        Resource filterCsvResource = resourceLoader.getResource("classpath:filter_data.csv");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(filterCsvResource.getInputStream()))){
            reader.readLine();
            String line;

            while((line = reader.readLine())!=null) {
                String filterName = line.trim();

                if (!filterRepository.existsByName(filterName)) {
                    Filter filter = new Filter();
                    filter.setName(filterName);
                    filterRepository.save(filter);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
