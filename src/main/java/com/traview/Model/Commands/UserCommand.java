package com.traview.Model.Commands;

import com.traview.Model.Enums.UserRole;
import lombok.Data;

@Data
public class UserCommand {
    String name;
    String username;
    String password;
    String surname;
    String email;
    UserRole userRole;
    boolean locked;
    boolean enabled;

    public UserCommand() {
    }

    public UserCommand(String name, String username, String password, String surname, String email, UserRole userRole) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.userRole = userRole;
    }
}
