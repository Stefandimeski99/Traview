package com.traview.Service;

import com.traview.Model.Commands.CityCommand;
import com.traview.Model.Dtos.CityDto;
import com.traview.Model.Entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CityService {
    Optional<CityDto> insertCity(CityCommand city);
    Optional<Page<City>> getCities(Pageable pageable);
}
