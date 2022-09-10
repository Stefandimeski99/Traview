package com.traview.Model.Dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ReviewDto {

    long id;

    UserDto user;

    DestinationDto destination;

    int numberOfLikes;

    String comment;

    Date date;

    int rating;
}
