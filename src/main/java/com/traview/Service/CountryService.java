package com.traview.Service;

import com.traview.Model.Commands.CountryCommand;
import com.traview.Model.Dtos.CountryDto;
import java.util.List;

public interface CountryService {
    List<CountryDto> getCountries();
    CountryDto insertCountry(CountryCommand countryCommand);
}
