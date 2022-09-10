package com.traview.Service;

import com.traview.Model.Commands.CountryCommand;
import com.traview.Model.Dtos.CountryDto;
import com.traview.Model.Entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CountryService {
    Optional<Page<Country>> getCountries(Pageable pageable);
    CountryDto insertCountry(CountryCommand countryCommand);
}
