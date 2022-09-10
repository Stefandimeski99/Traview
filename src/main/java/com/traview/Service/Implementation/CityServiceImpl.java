package com.traview.Service.Implementation;

import com.traview.Model.Commands.CityCommand;
import com.traview.Model.Dtos.CityDto;
import com.traview.Model.Entities.City;
import com.traview.Repository.CityRepository;
import com.traview.Service.CityService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Optional<Page<City>> getCities(Pageable pageable) {
        return Optional.of(this.cityRepository.findAll(pageable));
    }

    @Override
    public Optional<CityDto> insertCity(CityCommand cityCommand) {
        City cityEntity = this.cityRepository.save(ObjectMapperUtils.map(cityCommand, City.class));
        CityDto cityDto = ObjectMapperUtils.map(cityEntity, CityDto.class);
        return Optional.of(cityDto);
    }
}
