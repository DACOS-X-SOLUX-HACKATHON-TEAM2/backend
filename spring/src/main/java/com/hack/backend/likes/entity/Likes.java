package com.hack.backend.likes.entity;

import com.hack.backend.cosmetics.entity.Cosmetics;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Controller;

@Controller
public class Likes {

//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany
    @JoinColumn(name="cosmetics_id")
    private Cosmetics cosmetics;
}
