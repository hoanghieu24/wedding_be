package com.happywedding.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RsvpRequest {
    @NotBlank(message = "Tên khách mời không được để trống")
    private String guestName;

    private String phone;

    @Min(value = 1, message = "Số lượng khách phải từ 1 trở lên")
    private Integer guestCount = 1;

    @NotBlank(message = "Loại tham dự không được để trống")
    private String attendanceType;

    @NotBlank(message = "Trạng thái tham dự không được để trống")
    private String attendanceStatus;

    private String note;
}
