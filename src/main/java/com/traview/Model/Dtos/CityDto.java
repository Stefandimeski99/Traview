package com.traview.Model.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDto {
    Long id;
    CountryDto country;
    List<DestinationDto> destinations;
    String name;

    public CityDto() {
    }

    public CityDto(Long id, CountryDto country, List<DestinationDto> destinations, String name) {
        this.id = id;
        this.country = country;
        this.destinations = destinations;
        this.name = name;
    }
}
