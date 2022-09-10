package com.traview.Service;

import com.traview.Model.Commands.DestinationCommand;
import com.traview.Model.Dtos.DestinationDto;
import com.traview.Model.Entities.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DestinationService {
    Optional<Page<Destination>> getDestinations(Pageable pageable);
    DestinationDto insertDestination(DestinationCommand destinationCommand);
}
