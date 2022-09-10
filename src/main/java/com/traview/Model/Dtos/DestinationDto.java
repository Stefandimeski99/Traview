package com.traview.Model.Dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class DestinationDto {

    Long id;

    CityDto city;

    List<ReviewDto> reviews;

    String name;
}
