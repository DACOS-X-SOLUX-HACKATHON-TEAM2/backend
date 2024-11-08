package com.hack.backend.user.dto;

public record LoginResponseDto(
        String message,
        String token
) {
}
