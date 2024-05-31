package org.sparta.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.schedule.dto.CommentRequestDto;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "comment")
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_detail")
    private String comment_detail;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "sch_id")
    private String sch_id;



    public Comment(CommentRequestDto requestDto) {
        this.comment_detail = requestDto.getComment_detail();
        this.passwd = requestDto.getPasswd();
        this.sch_id = requestDto.getSch_id();
        this.user_id = requestDto.getUser_id();
    }


}
