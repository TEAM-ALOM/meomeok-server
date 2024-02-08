package com.example.meomeokserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MenuDTO {

    private Long id;
    private String name;
    private Set<FilterDTO> filterDTOS;
}
