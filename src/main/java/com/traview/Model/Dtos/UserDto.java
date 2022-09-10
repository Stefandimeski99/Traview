package com.traview.Model.Dtos;

import com.traview.Model.Entities.Review;
import com.traview.Model.Enums.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    Long id;
    List<Review> reviews;
    String name;
    String username;
    String password;
    String surname;
    String email;
    UserRole userRole;
    boolean locked;
    boolean enabled;

    public UserDto() {
    }

    public UserDto(String name, String username, String password, String surname, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
    }
}
