package com.hack.backend.user;

import com.hack.backend.security.jwt.JwtUtil;
import com.hack.backend.user.dto.JoinRequestDto;
import com.hack.backend.user.dto.LoginRequestDto;
import com.hack.backend.user.dto.LoginResponseDto;
import com.hack.backend.user.entity.User;
import com.hack.backend.user.repository.UserRepository;
import com.hack.backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;




@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @Test
    void saveUser_success() {
        //given
        JoinRequestDto requestDto = new JoinRequestDto("youkm", "youkm321!");
        User savedUser = User.builder()
                .id(requestDto.id())
                .password(requestDto.password())
                .build();
        //stub
        when(userRepository.save(any())).thenReturn(savedUser);
        when(userRepository.existsById(requestDto.id())).thenReturn(false);  //

        //when
        userService.join(requestDto);

        //then
        verify(userRepository).existsById(requestDto.id());
        verify(userRepository).save(any());
    }

    @Test
    void login_success() {
        //given
        LoginRequestDto loginRequestDto = new LoginRequestDto("youkm", "youkm321!");
        User user = User.builder()
                .id(loginRequestDto.id())
                .password(loginRequestDto.password())
                .build();
        String token = "garaToken";

        //stub
        when(userRepository.findById(loginRequestDto.id())).thenReturn(Optional.of(user));
        when(bCryptPasswordEncoder.matches(loginRequestDto.password(), user.getPassword())).thenReturn(true);
        when(jwtUtil.createToken(user.getId())).thenReturn(token);

        //when
        String result = userService.login(loginRequestDto);

        //then
        assertEquals(token, result);
        verify(userRepository).findById(loginRequestDto.id());
        verify(bCryptPasswordEncoder).matches(loginRequestDto.password(), user.getPassword());
        verify(jwtUtil).createToken(user.getId());

    }

}
