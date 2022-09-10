package com.traview.Model.Dtos;

import com.traview.Model.Entities.Country;
import com.traview.Model.Entities.Destination;
import lombok.Data;

import java.util.List;

@Data
public class CityDto {
    Long id;
    Country country;
    List<Destination> destinations;
    String name;

    public CityDto() {
    }

    public CityDto(Long id, Country country, List<Destination> destinations, String name) {
        this.id = id;
        this.country = country;
        this.destinations = destinations;
        this.name = name;
    }
}
