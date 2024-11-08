package com.hack.backend.user;

import com.hack.backend.user.dto.JoinRequestDto;
import com.hack.backend.user.entity.User;
import com.hack.backend.user.repository.UserRepository;
import com.hack.backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;




@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

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
        when(userRepository.existsByIdCustom(requestDto.id())).thenReturn(false);  //

        //when
        userService.join(requestDto);
        //then
        verify(userRepository).existsByIdCustom(requestDto.id());
        verify(userRepository).save(any());
    }
}
