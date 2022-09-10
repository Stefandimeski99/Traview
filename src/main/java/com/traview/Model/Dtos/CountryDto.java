package com.traview.Model.Dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CountryDto {

    Long id;

    List<CityDto> cities;

    String name;
}
