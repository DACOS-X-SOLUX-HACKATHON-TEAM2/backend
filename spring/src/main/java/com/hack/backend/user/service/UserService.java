package com.hack.backend.user.service;

import com.hack.backend.user.dto.JoinRequestDto;
import com.hack.backend.user.entity.User;
import com.hack.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    //private final PasswordEncoder encoder;

    @Transactional
    public User join(JoinRequestDto request) {
        if (userRepository.existsByIdCustom(request.id())) {
            throw new IllegalArgumentException("User already exists");
        }
        User user = User.builder()
                .id(request.id())
                .password(request.password())
                .build();

        return userRepository.save(user);
    }
}
