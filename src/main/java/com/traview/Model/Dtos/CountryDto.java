package com.traview.Model.Dtos;

import com.traview.Model.Entities.City;
import lombok.Data;

import java.util.List;

@Data
public class CountryDto {
    Long id;
    List<City> cities;
    String name;

    public CountryDto(List<City> cities, String name) {
        this.cities = cities;
        this.name = name;
    }
}
