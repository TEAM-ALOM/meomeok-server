package com.example.meomeokserver.service;

import com.example.meomeokserver.domain.Filter;
import com.example.meomeokserver.domain.Menu;
import com.example.meomeokserver.repository.FilterRepository;
import com.example.meomeokserver.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;

    public List<Filter> getAllFilter() {
        return filterRepository.findAll();
    }
}
