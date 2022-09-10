package com.traview.Model.Commands;

import com.traview.Model.Entities.City;
import lombok.Data;

@Data
public class DestinationCommand {
    City city;
    String name;

    public DestinationCommand(City city, String name) {
        this.city = city;
        this.name = name;
    }
}
