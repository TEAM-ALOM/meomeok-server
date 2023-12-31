package com.example.meomeokserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID", unique = true, nullable = false)
    private Long id;

    @Column(length = 45, name = "NAME")
    private String name;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Filter> filterList;

}
