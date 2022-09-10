package com.traview.Service.Implementation;

import com.traview.Model.Commands.DestinationCommand;
import com.traview.Model.Dtos.DestinationDto;
import com.traview.Model.Entities.Destination;
import com.traview.Repository.DestinationRepository;
import com.traview.Service.DestinationService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Optional<Page<Destination>> getDestinations(Pageable pageable) {
        return Optional.of(this.destinationRepository.findAll(pageable));
    }

    @Override
    public DestinationDto insertDestination(DestinationCommand destinationCommand) {
        Destination destinationEntity = this.destinationRepository.save(ObjectMapperUtils.map(destinationCommand, Destination.class));
        return ObjectMapperUtils.map(destinationEntity, DestinationDto.class);
    }
}
