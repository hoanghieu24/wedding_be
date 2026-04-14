package com.happywedding.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "rsvps")
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String guestName;

    @Column(length = 30)
    private String phone;

    @Column(name = "guest_count")
    private Integer guestCount = 1;

    @Column(name = "attending_status", length = 50)
    private String attendanceStatus;

    @Column(name = "attendance_type", length = 50)
    private String attendanceType;

    @Column(name = "wishes", columnDefinition = "TEXT")
    private String note;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (guestCount == null || guestCount < 1) {
            guestCount = 1;
        }
    }
}
