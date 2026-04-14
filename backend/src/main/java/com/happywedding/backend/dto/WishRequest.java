package com.happywedding.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishRequest {
    @NotBlank(message = "Tên khách mời không được để trống")
    private String guestName;

    @NotBlank(message = "Lời chúc không được để trống")
    private String message;
}
