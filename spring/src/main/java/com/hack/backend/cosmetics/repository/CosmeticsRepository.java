package com.hack.backend.cosmetics.repository;

import com.hack.backend.cosmetics.entity.Cosmetics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosmeticsRepository extends JpaRepository<Long, Cosmetics> {
}
