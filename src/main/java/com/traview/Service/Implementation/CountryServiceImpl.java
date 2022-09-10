package com.traview.Service.Implementation;

import com.traview.Model.Commands.CountryCommand;
import com.traview.Model.Dtos.CountryDto;
import com.traview.Model.Entities.Country;
import com.traview.Repository.CountryRepository;
import com.traview.Service.CountryService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Page<Country>> getCountries(Pageable pageable) {
        return Optional.of(this.countryRepository.findAll(pageable));
    }

    @Override
    public CountryDto insertCountry(CountryCommand countryCommand) {
        Country countryEntity = this.countryRepository.save(ObjectMapperUtils.map(countryCommand, Country.class));
        return ObjectMapperUtils.map(countryEntity, CountryDto.class);
    }
}
