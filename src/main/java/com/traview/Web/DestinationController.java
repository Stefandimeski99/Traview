package com.traview.Web;

import com.traview.Model.Commands.DestinationCommand;
import com.traview.Service.DestinationService;
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
    public ResponseEntity getAllDestinations() {
        return ResponseEntity.ok(this.destinationService.getDestinations());
    }

    @PostMapping
    public ResponseEntity insertDestination(@RequestBody DestinationCommand destinationCommand) {
        return ResponseEntity.ok(this.destinationService.insertDestination(destinationCommand));
    }
}
