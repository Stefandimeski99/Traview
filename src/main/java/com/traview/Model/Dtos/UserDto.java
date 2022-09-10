package com.traview.Model.Dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDto {

    Long id;

    List<ReviewDto> reviews;

    String name;

    String username;

    String password;

    String surname;
}
