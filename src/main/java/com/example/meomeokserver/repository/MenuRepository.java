package com.example.meomeokserver.repository;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT menu FROM Menu menu WHERE menu.filters IS NOT EMPTY AND menu.filters IN :filters")
    List<Menu> findByFiltersContains(@Param("filters") List<Filter> filters);

    boolean existsByName(String menuName);
}
