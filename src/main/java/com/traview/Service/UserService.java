package com.traview.Service;


import com.traview.Model.Commands.UserCommand;
import com.traview.Model.Dtos.UserDto;

import java.util.List;

public interface UserService {
    UserDto userLogin(String username, String password);
    UserDto userRegister(UserCommand userCommand);
    List<UserDto> getUsers();
}
