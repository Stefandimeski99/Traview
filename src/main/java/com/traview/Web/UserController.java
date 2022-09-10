package com.traview.Web;

import com.traview.Model.Commands.UserCommand;
import com.traview.Model.Dtos.UserDto;
import com.traview.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserCommand userCommand) {
        try {
            UserDto userDto = this.userService.registerUser(userCommand);
            return ResponseEntity.ok(userDto);
        } catch (IllegalStateException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
