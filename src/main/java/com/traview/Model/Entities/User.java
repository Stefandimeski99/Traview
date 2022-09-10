package com.traview.Model.Entities;

import com.traview.Model.Enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Table(name = "users")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue
    Long id;
    @OneToMany(mappedBy = "user")
    List<Review> reviews;
    @OneToMany(mappedBy = "user")
    List<ConfirmationToken> confirmationTokens;
    String name;
    String username;
    String password;
    String surname;
    String email;
    @Enumerated(EnumType.STRING)
    UserRole userRole;
    boolean locked;
    boolean enabled;

    public User() {
    }

    public User(String name, String username, String password, String surname, String email, UserRole userRole, boolean locked, boolean enabled) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.userRole = userRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
