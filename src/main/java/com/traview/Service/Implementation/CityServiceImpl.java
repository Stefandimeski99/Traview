package com.traview.Service.Implementation;

import com.traview.Model.Commands.CityCommand;
import com.traview.Model.Dtos.CityDto;
import com.traview.Model.Entities.City;
import com.traview.Repository.CityRepository;
import com.traview.Service.CityService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDto> getCities() {
        return ObjectMapperUtils.mapAll(this.cityRepository.findAll(), CityDto.class);
    }

    @Override
    public CityDto insertCity(CityCommand cityCommand) {
        City cityEntity = this.cityRepository.save(ObjectMapperUtils.map(cityCommand, City.class));
        return ObjectMapperUtils.map(cityEntity, CityDto.class);
    }
}
