package com.hack.backend.survey.entity;

import com.hack.backend.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Survey {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Survey(User user, String contents) {
        this.user = user;
        this.contents = contents;
    }

}
