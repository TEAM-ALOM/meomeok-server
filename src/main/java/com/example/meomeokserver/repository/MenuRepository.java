package com.example.meomeokserver.repository;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    //List<Menu> findById(List<Filter> filterList);
    //Optional<Menu> resultMenu(List<Menu> menuList);
}