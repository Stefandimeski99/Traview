package com.traview.Service.Implementation;

import com.traview.Model.Dtos.ConfirmationTokenDto;
import com.traview.Model.Entities.ConfirmationToken;
import com.traview.Repository.ConfirmationTokenRepository;
import com.traview.Service.ConfirmationTokenService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenServiceImpl(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public void saveConfirmationToken(ConfirmationTokenDto confirmationTokenDto) {
        this.confirmationTokenRepository.save(ObjectMapperUtils.map(confirmationTokenDto, ConfirmationToken.class));
    }
}
