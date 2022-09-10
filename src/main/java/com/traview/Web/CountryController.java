package com.traview.Web;

import com.traview.Model.Commands.CountryCommand;
import com.traview.Service.CountryService;
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
    public ResponseEntity getAllCountries() {
        return ResponseEntity.ok(this.countryService.getCountries());
    }

    @PostMapping
    public ResponseEntity insertCountry(@RequestBody CountryCommand countryCommand) {
        return ResponseEntity.ok(this.countryService.insertCountry(countryCommand));
    }
}
