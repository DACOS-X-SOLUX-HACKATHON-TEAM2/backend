package com.hack.backend.likes.entity;

import com.hack.backend.cosmetics.entity.Cosmetics;
import com.hack.backend.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;


@Controller
@Builder
@Getter
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="cosmetics_id")
    private Cosmetics cosmetics;


}