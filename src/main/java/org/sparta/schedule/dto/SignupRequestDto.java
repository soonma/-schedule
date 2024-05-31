package org.sparta.schedule.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    @NotBlank
    @Pattern(regexp = "^[a-z0-9]+$",message = "영문 숫자만 가능합니다.")
    @Size(min = 4, message = "최소값 4자 이상으로 입력 해주시길 바랍니다")
    private String username;

    @NotBlank
    @Size(min = 8,message = "최소값 8자 이상으로 입력 해주시길 바랍니다")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "영문 숫자만 가능합니다.")
    private String passwd;

    @NotBlank
    private String nickname;

    private boolean admin = false;
    private String adminToken = "";

}