package com.hack.backend.user.repository;

import com.hack.backend.user.entity.User;
import org.reactivestreams.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;


//DAO의 기능은 JpaRepository가 하므로 있을 필요 없으며 @Repository 또한 동일.
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdCustom(String id);
    boolean existsByIdCustom(String id);

}
