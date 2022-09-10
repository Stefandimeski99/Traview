package com.traview.Web;

import com.traview.Model.Commands.CityCommand;
import com.traview.Model.Dtos.CityDto;
import com.traview.Model.Entities.City;
import com.traview.Service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public ResponseEntity<Page<City>> getCities(Pageable pageable) {
        return this.cityService.getCities(pageable)
                .map(cities -> ResponseEntity.ok(cities))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CityDto> insertCity(@RequestBody CityCommand cityCommand) {
        return this.cityService.insertCity(cityCommand)
                .map(city -> ResponseEntity.ok(city))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
