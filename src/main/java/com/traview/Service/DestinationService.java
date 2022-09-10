package com.traview.Service;

import com.traview.Model.Commands.DestinationCommand;
import com.traview.Model.Dtos.DestinationDto;

import java.util.List;

public interface DestinationService {
    List<DestinationDto> getDestinations();
    DestinationDto insertDestination(DestinationCommand destinationCommand);
}
