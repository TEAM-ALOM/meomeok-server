package com.example.meomeokserver.repository;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long> {

}