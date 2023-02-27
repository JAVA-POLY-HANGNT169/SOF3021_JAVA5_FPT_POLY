package com.poly.hangnt169.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hangnt169
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LopHocRequest {

    private Long id;

    @NotEmpty(message = "Mã lớp không được để trống")
    private String maLop;

    @NotEmpty(message = "Tên Lớp không được để trống")
    private String tenLop;

    private Integer soLuongSV;

}
