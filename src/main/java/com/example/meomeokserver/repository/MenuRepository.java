package com.example.meomeokserver.repository;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "SELECT menus FROM Menu menus JOIN menus.filterList Filter WHERE Filter IN : filters ORDER BY RAND() LIMIT 1")
    Optional<Menu> findRandomMenuByFilterListIn(@Param("filters") List<Filter> filters);
}