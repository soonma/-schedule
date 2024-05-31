package org.sparta.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    @NotBlank
    private String comment_detail;

    @NotBlank
    private String sch_id;

    @NotBlank
    private String passwd;

    private Long user_id;
}
