package org.sparta.schedule.dto;

import lombok.Getter;
import org.sparta.schedule.entity.Comment;

@Getter
public class CommentResponseDto {
    Long id;
    String comment_detail;
    String sch_id;
    Long user_id;
    String write_date;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment_detail = comment.getComment_detail();
        this.user_id = comment.getUser_id();
        this.sch_id = comment.getSch_id();
        this.write_date = comment.getWriteDate();
    }
}
