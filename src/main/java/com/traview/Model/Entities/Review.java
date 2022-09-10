package com.traview.Model.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    User user;

    @ManyToOne
    Destination destination;

    int numberOfLikes;

    String comment;

    Date date;

    int rating;

    public Review() {
    }

    public Review(User user, Destination destination, int numberOfLikes, String comment, Date date, int rating) {
        this.user = user;
        this.destination = destination;
        this.numberOfLikes = numberOfLikes;
        this.comment = comment;
        this.date = date;
        this.rating = rating;
    }
}
