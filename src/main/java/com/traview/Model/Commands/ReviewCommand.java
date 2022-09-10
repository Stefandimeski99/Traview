package com.traview.Model.Commands;

import com.traview.Model.Entities.Destination;
import com.traview.Model.Entities.User;
import java.util.Date;

public class ReviewCommand {
    User user;
    Destination destination;
    String comment;
    Date date;

    public ReviewCommand(User user, Destination destination, String comment, Date date) {
        this.user = user;
        this.destination = destination;
        this.comment = comment;
        this.date = date;
    }
}
