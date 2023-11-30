package com.example.meomeokserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FILTER_ID", unique = true, nullable = false)
    private Long id;

    @Column(length = 45, name = "NAME")
    private String name;

    @ManyToOne(targetEntity = Menu.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

}
