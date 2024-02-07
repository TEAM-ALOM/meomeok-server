package com.example.meomeokserver.repository;

import com.example.meomeokserver.domain.Filter;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@NonNullApi
@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {

    Filter findByName(String filterName);
    boolean existsByName(String filterName);
}
