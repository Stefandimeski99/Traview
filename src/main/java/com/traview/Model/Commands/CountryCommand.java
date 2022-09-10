package com.traview.Model.Commands;

import lombok.Data;

@Data
public class CountryCommand {
    String name;

    public CountryCommand(String name) {
        this.name = name;
    }
}
