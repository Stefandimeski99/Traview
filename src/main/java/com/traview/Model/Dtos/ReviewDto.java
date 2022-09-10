package com.traview.Model.Dtos;

import com.traview.Model.Entities.Destination;
import com.traview.Model.Entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {
    long id;
    User user;
    Destination destination;
    int numberOfLikes;
    String comment;
    Date date;
    int rating;

    public ReviewDto(User user, Destination destination, int numberOfLikes, String comment, Date date, int rating) {
        this.user = user;
        this.destination = destination;
        this.numberOfLikes = numberOfLikes;
        this.comment = comment;
        this.date = date;
        this.rating = rating;
    }
}
