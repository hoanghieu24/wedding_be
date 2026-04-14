package com.happywedding.backend.repository;

import com.happywedding.backend.entity.SiteContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteContentRepository extends JpaRepository<SiteContent, Long> {
    Optional<SiteContent> findTopByOrderByIdAsc();
}
