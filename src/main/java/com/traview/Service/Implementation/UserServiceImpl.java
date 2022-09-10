package com.traview.Service.Implementation;

import com.traview.Model.Commands.UserCommand;
import com.traview.Model.Dtos.UserDto;
import com.traview.Model.Entities.User;
import com.traview.Repository.UserRepository;
import com.traview.Service.UserService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto userLogin(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        if(user == null) {
            //TODO: vrati error
        }
        return ObjectMapperUtils.map(user, UserDto.class);
    }

    @Override
    public UserDto userRegister(UserCommand userCommand) {
        User user = this.userRepository.findByUsername(userCommand.getUsername());
        if(user != null) {
            //TODO: vrati error
        }
        User userEntity = this.userRepository.save(ObjectMapperUtils.map(userCommand, User.class));
        return ObjectMapperUtils.map(userEntity, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        return ObjectMapperUtils.mapAll(this.userRepository.findAll(), UserDto.class);
    }
}
