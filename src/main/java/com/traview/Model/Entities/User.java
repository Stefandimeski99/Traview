package com.traview.Model.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;

    String name;

    String username;

    String password;

    String surname;

    public User() {
    }

    public User(String name, String username, String password, String surname) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
    }
}
