package com.traview.Model.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class City {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Country country;
    @OneToMany(mappedBy = "city")
    List<Destination> destinations;
    String name;

    public City() {
    }

    public City(Country country, List<Destination> destinations, String name) {
        this.country = country;
        this.destinations = destinations;
        this.name = name;
    }
}
