package com.traview.Model.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Country {
    @Id
    @GeneratedValue
    Long id;
    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<City> cities;
    String name;

    public Country() {
    }

    public Country(List<City> cities, String name) {
        this.cities = cities;
        this.name = name;
    }
}
