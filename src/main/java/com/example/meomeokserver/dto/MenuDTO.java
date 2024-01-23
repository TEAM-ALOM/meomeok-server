package com.example.meomeokserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MenuDTO {

    private Long id;
    private String name;
}
