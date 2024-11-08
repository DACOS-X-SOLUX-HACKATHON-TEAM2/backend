package com.hack.backend.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record JoinRequestDto(
        @NotBlank(message = "아이디는 필수입니다")
        @Size(min = 4, max = 20, message = "아이디는 4~20자 사이여야 합니다.")
        String id,

        @NotBlank(message = "비밀번호는 필수입니다")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
                message = "비밀번호는 8자 이상, 영문/숫자 조합이어야 합니다")
        String password,

        @NotBlank(message = "이름은 필수입니다")
        String name
) {}
