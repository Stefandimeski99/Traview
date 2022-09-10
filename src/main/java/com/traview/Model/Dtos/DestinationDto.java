package com.traview.Model.Dtos;

import com.traview.Model.Entities.City;
import com.traview.Model.Entities.Review;
import lombok.Data;

import java.util.List;

@Data
public class DestinationDto {
    Long id;
    City city;
    List<Review> reviews;
    String name;

    public DestinationDto(City city, List<Review> reviews, String name) {
        this.city = city;
        this.reviews = reviews;
        this.name = name;
    }
}
