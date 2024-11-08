package com.hack.backend.user.controller;

import com.hack.backend.user.dto.JoinRequestDto;
import com.hack.backend.user.dto.JoinResponseDto;
import com.hack.backend.user.entity.User;
import com.hack.backend.user.service.UserService;
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
    public User login(@RequestBody User user) {
        return user;
    }

    @PostMapping("/join")
    public ResponseEntity<JoinResponseDto> join(@Valid @RequestBody JoinRequestDto joinRequestDto) {
        userService.join(joinRequestDto);
        return ResponseEntity.ok(new JoinResponseDto("회원가입 성공하였습니다."));
    }

    @PostMapping("/logout")
    public User logout(@RequestBody User user) {
        return user; //추후 스프링 시큐리티 logout
    }
}
