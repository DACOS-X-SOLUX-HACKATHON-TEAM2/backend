package com.hack.backend.likes.repository;

import com.hack.backend.likes.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Long, Likes> {
}
