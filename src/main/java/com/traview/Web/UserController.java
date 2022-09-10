package com.traview.Web;

import com.traview.Model.Commands.UserCommand;
import com.traview.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserCommand userCommand) {
        return ResponseEntity.ok(this.userService.userRegister(userCommand));
    }
}
