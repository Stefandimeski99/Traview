package com.traview.Model.Commands;

import com.traview.Model.Dtos.CountryDto;
import lombok.Data;

@Data
public class CityCommand {
    String name;
    CountryDto country;

    public CityCommand(String name, CountryDto country) {
        this.name = name;
        this.country = country;
    }
}
