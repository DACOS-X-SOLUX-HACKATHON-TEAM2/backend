package com.hack.backend.user.service;

import com.hack.backend.security.jwt.JwtUtil;
import com.hack.backend.user.dto.JoinRequestDto;
import com.hack.backend.user.dto.LoginRequestDto;
import com.hack.backend.user.entity.User;
import com.hack.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public void join(JoinRequestDto request) {
        if (userRepository.existsById(request.id())) {
            throw new IllegalArgumentException("사용자가 이미 있습니다.");
        }
        User user = User.builder()
                .name(request.name())
                .id(request.id())
                .password(passwordEncoder.encode(request.password()))
                .build();
        userRepository.save(user);
    }

    @Transactional
    public String login(LoginRequestDto request) {
        User user = userRepository.findById(request.id())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        return jwtUtil.createToken(user.getId());
    }
}
