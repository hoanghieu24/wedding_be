package com.happywedding.backend.repository;

import com.happywedding.backend.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishRepository extends JpaRepository<Wish, Long> {
    List<Wish> findAllByVisibleTrueOrderByCreatedAtDesc();
    List<Wish> findAllByOrderByCreatedAtDesc();
}
