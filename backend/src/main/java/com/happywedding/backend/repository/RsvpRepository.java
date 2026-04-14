package com.happywedding.backend.repository;

import com.happywedding.backend.entity.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
    List<Rsvp> findAllByOrderByCreatedAtDesc();
}
