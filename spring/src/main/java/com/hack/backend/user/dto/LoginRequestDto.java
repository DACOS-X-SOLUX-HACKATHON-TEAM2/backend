package com.hack.backend.user.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
        @NotBlank(message = "아이디는 필수입니다.")
        String id,

        @NotBlank(message = "비밀번호는 필수입니다")
        String password
) {
}
