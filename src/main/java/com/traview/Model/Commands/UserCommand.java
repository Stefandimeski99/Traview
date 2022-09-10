package com.traview.Model.Commands;

import com.traview.Model.Entities.Review;
import lombok.Data;
import org.springframework.lang.Nullable;
import java.util.List;

@Data
public class UserCommand {
    String name;
    String username;
    String password;
    String surname;

    public UserCommand(String name, String username, String password, String surname) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
    }
}
