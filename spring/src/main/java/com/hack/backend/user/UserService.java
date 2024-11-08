package com.hack.backend.user;

import com.hack.backend.user.dto.JoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    //private final PasswordEncoder encoder;
    public void join(JoinRequestDto request) {
        if (userRepository.existsById(request.id())) {
            throw new IllegalArgumentException("User already exists");
        }
        User user = User.builder()
                .id(request.id())
                .password(request.password())
                .build();

        userRepository.save(user);
    }
}
