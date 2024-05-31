package org.sparta.schedule.service;

import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.sparta.schedule.dto.CommentRequestDto;
import org.sparta.schedule.dto.CommentResponseDto;
import org.sparta.schedule.entity.Comment;
import org.sparta.schedule.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Slf4j
@Service
public class CommentService {

    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentResponseDto addComment(CommentRequestDto requestDto) {
        try {
            Comment comment = new Comment(requestDto);

            commentRepository.save(comment);

            CommentResponseDto responseDto = new CommentResponseDto(comment);

            return responseDto;
        } catch (RuntimeException e){
            log.info(e.getMessage());
        }
        return null;
    }

    @Transactional
    public void updateComment(Long id, CommentRequestDto requestDto) {
        Comment comment = findComment(id);

        boolean haspasswd = StringUtils.hasLength(requestDto.getPasswd());//null 일경우 false 반환
        boolean checkpasswd = comment.getPasswd().equals(requestDto.getPasswd());

        if (haspasswd && checkpasswd) {
            comment.setComment_detail(requestDto.getComment_detail());
        } else {
            System.out.println("비밀번호가 일치 하지 않습니다");
        }

    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 댓글은 존재 하지 않습니다."));
    }

    public void deleteComment(Long id, CommentRequestDto requestDto) {
        Comment comment = findComment(id);

        boolean haspasswd = StringUtils.hasLength(requestDto.getPasswd());//null 일경우 false 반환
        boolean checkpasswd = comment.getPasswd().equals(requestDto.getPasswd());

        if (haspasswd && checkpasswd) {
            commentRepository.delete(comment);
        } else {
            System.out.println("비밀번호가 일치 하지 않습니다");
        }
    }
}
