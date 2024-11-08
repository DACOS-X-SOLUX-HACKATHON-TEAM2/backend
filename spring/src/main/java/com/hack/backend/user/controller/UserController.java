package com.hack.backend.user.controller;

import com.hack.backend.user.dto.*;
import com.hack.backend.user.entity.User;
import com.hack.backend.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        String token = userService.login(loginRequestDto);
        return ResponseEntity.ok(new LoginResponseDto("로그인하였습니다.", token));
    }

    @PostMapping("/join")
    public ResponseEntity<JoinResponseDto> join(@Valid @RequestBody JoinRequestDto joinRequestDto) {
        userService.join(joinRequestDto);
        return ResponseEntity.ok(new JoinResponseDto("회원가입 성공하였습니다."));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponseDto> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            //redis에 토큰 삭제
        }
        return ResponseEntity.ok(new LogoutResponseDto("로그아웃되었습니다."));
    }
}
