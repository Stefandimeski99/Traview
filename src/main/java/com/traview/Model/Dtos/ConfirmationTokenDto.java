package com.traview.Model.Dtos;

import com.traview.Model.Entities.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConfirmationTokenDto {
    String token;
    LocalDateTime createdAt;
    LocalDateTime expiresAt;
    User user;

    public ConfirmationTokenDto(String token, LocalDateTime createdAt, LocalDateTime expiresAt, User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
