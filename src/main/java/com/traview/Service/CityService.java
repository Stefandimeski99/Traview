package com.traview.Service;

import com.traview.Model.Commands.CityCommand;
import com.traview.Model.Dtos.CityDto;
import java.util.List;

public interface CityService {
    List<CityDto> getCities();
    CityDto insertCity(CityCommand city);
}
