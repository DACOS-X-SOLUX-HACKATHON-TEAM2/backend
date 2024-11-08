package com.hack.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//DAO의 기능은 JpaRepository가 하므로 있을 필요 없으며 @Repository 또한 동일.
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String userId);
    boolean existsById(String userId);

}
