package com.example.meomeokserver.config;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import com.example.meomeokserver.repository.FilterRepository;
import com.example.meomeokserver.repository.MenuRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

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

    @PostConstruct
    public void loadCsvData() {
        loadMenuData();
        loadFilterData();
        loadFiltersSetData();
        loadMenusSetData();
    }

    private void loadMenuData() {
        Resource menuCsvResource = resourceLoader.getResource("classpath:menu_data.csv");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(menuCsvResource.getInputStream()))){
            menuRepository.deleteAll();

            reader.readLine();
            String line;

            while((line = reader.readLine())!=null) {
                String[] parts = line.split(",");
                String menuName = parts[0].trim();

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
            filterRepository.deleteAll();

            reader.readLine();
            String line;

            while((line = reader.readLine())!=null) {
                String[] parts = line.split(",");
                String filterName = parts[0].trim();

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

    private void loadFiltersSetData() {
        Resource menuCsvResource = resourceLoader.getResource("classpath:menu_data.csv");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(menuCsvResource.getInputStream()))){

            reader.readLine();
            String line;

            while((line = reader.readLine())!=null) {
                String[] parts = line.split(",");
                String menuName = parts[0].trim();
                Menu menu = menuRepository.findByName(menuName);

                if (menu != null) {
                    menu.setFilters(new HashSet<>());

                    for (int i = 1; i < parts.length; i++) {
                        String filterName = parts[i].trim();
                        Filter filter = filterRepository.findByName(filterName);
                        if (filter != null) {
                            menu.getFilters().add(filter);
                        }
                    }

                    menuRepository.save(menu);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMenusSetData() {
        Resource filterCsvResource = resourceLoader.getResource("classpath:filter_data.csv");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(filterCsvResource.getInputStream()))){

            reader.readLine();
            String line;

            while((line = reader.readLine())!=null) {
                String[] parts = line.split(",");
                String filterName = parts[0].trim();
                Filter filter = filterRepository.findByName(filterName);

                if (filter != null) {
                    filter.setMenus(new HashSet<>());

                    for (int i = 1; i < parts.length; i++) {
                        String menuName = parts[i].trim();
                        Menu menu = menuRepository.findByName(menuName);
                        if (menu != null) {
                            filter.getMenus().add(menu);
                        }
                    }

                    filterRepository.save(filter);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
