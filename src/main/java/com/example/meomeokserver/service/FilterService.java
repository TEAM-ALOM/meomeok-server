package com.example.meomeokserver.service;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.dto.FilterDTO;
import com.example.meomeokserver.repository.FilterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class FilterService {

    private final FilterRepository filterRepository;


    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public List<FilterDTO> findAll() {
        List<Filter> filters = filterRepository.findAll();

        return filters.stream().map(filter -> new FilterDTO(filter.getId(), filter.getName())).collect(Collectors.toList());
    }
}
