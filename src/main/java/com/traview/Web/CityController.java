package com.traview.Web;

import com.traview.Model.Commands.CityCommand;
import com.traview.Model.Dtos.CityDto;
import com.traview.Service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity getAllCities() {
        return ResponseEntity.ok(this.cityService.getCities());
    }

    @PostMapping
    public ResponseEntity insertCity(@RequestBody CityCommand cityCommand) {
        return ResponseEntity.ok(this.cityService.insertCity(cityCommand));
    }
}
