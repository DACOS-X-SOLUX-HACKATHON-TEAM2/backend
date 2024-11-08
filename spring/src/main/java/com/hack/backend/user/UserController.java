package com.hack.backend.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return user;
    }

    @PostMapping("/join")
    public User join(@RequestBody User user) {
        return user;
    }

    @PostMapping("/logout")
    public User logout(@RequestBody User user) {
        return user; //추후 스프링 시큐리티 logout
    }
}
