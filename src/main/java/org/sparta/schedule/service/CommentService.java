package org.sparta.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.sparta.schedule.dto.CommentRequestDto;
import org.sparta.schedule.dto.CommentResponseDto;
import org.sparta.schedule.entity.Comment;
import org.sparta.schedule.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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


}
