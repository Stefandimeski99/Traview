package com.traview.Web;

import com.traview.Model.Commands.DestinationCommand;
import com.traview.Service.DestinationService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/destination")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public ResponseEntity getAllDestinations(Pageable pageable) {
        return this.destinationService.getDestinations(pageable)
                .map(destinations -> ResponseEntity.ok(destinations))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity insertDestination(@RequestBody DestinationCommand destinationCommand) {
        return ResponseEntity.ok(this.destinationService.insertDestination(destinationCommand));
    }
}
