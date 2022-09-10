package com.traview.Model.Commands;

import com.traview.Model.Entities.Country;
import lombok.Data;

@Data
public class CityCommand {
    String name;
    Country country;

    public CityCommand(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
