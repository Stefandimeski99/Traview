package com.traview.Model.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Destination {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    City city;

    @OneToMany(mappedBy = "destination")
    List<Review> reviews;

    String name;

    public Destination() {
    }

    public Destination(City city, List<Review> reviews, String name) {
        this.city = city;
        this.reviews = reviews;
        this.name = name;
    }
}
