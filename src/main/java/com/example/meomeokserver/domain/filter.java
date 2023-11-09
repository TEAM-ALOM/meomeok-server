package com.example.meomeokserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class filter {
    @Id
    @Column(name="FILTER_ID", unique = true, nullable = false)
    private Long id;

    @Column(length = 45, name = "NAME")
    private String name;

    @ManyToOne(targetEntity = menu.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private menu menu;

}
