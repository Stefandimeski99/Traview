package com.traview.Service;

import com.traview.Model.Commands.UserCommand;
import com.traview.Model.Dtos.UserDto;

public interface UserService {
    UserDto registerUser(UserCommand userCommand);
}
