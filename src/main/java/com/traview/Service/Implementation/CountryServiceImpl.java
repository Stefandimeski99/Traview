package com.traview.Service.Implementation;

import com.traview.Model.Commands.CountryCommand;
import com.traview.Model.Dtos.CountryDto;
import com.traview.Model.Entities.Country;
import com.traview.Repository.CountryRepository;
import com.traview.Service.CountryService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDto> getCountries() {
        return ObjectMapperUtils.mapAll(this.countryRepository.findAll(), CountryDto.class);
    }

    @Override
    public CountryDto insertCountry(CountryCommand countryCommand) {
        Country countryEntity = this.countryRepository.save(ObjectMapperUtils.map(countryCommand, Country.class));
        return ObjectMapperUtils.map(countryEntity, CountryDto.class);
    }
}
