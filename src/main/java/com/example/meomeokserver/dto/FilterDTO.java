package com.example.meomeokserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FilterDTO {

    private Long id;
    private String name;
}
