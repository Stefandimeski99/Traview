package com.traview.Web;

import com.traview.Model.Commands.CountryCommand;
import com.traview.Service.CountryService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity getCountries(Pageable pageable) {
        return this.countryService.getCountries(pageable)
                .map(countries -> ResponseEntity.ok(countries))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity insertCountry(@RequestBody CountryCommand countryCommand) {
        return ResponseEntity.ok(this.countryService.insertCountry(countryCommand));
    }
}
