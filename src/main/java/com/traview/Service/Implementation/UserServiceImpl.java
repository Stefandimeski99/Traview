package com.traview.Service.Implementation;

import com.traview.Model.Commands.UserCommand;
import com.traview.Model.Dtos.ConfirmationTokenDto;
import com.traview.Model.Dtos.UserDto;
import com.traview.Model.Entities.User;
import com.traview.Repository.UserRepository;
import com.traview.Service.ConfirmationTokenService;
import com.traview.Service.UserService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final Long CONFIRMATION_TOKEN_DURATION = Long.valueOf(15);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));
    }

    @Override
    public UserDto registerUser(UserCommand userCommand) {
        boolean exists = this.userRepository.findByUsername(userCommand.getUsername()).isPresent();
        if(exists) {
            throw new IllegalStateException("Username already taken");
        }
        userCommand.setPassword(bCryptPasswordEncoder.encode(userCommand.getPassword()));
        User userEntity = userRepository.save(ObjectMapperUtils.map(userCommand, User.class));
        ConfirmationTokenDto confirmationTokenDto = new ConfirmationTokenDto(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(this.CONFIRMATION_TOKEN_DURATION),
                userEntity
        );
        this.confirmationTokenService.saveConfirmationToken(confirmationTokenDto);

        return ObjectMapperUtils.map(userEntity, UserDto.class);
    }
}
