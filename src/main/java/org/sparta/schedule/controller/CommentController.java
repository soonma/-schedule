package org.sparta.schedule.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.sparta.schedule.dto.CommentRequestDto;
import org.sparta.schedule.dto.CommentResponseDto;
import org.sparta.schedule.service.CommentService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CommentController {


    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public String addComment(@Valid CommentRequestDto requestDto, BindingResult bindingResult){
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return  bindingResult.getFieldError().getDefaultMessage();
        } else{
            commentService.addComment(requestDto);
            return "데이터 저장 성공";
        }
        //return commentService.addComment(requestDto);
    }
    @PutMapping("/comment/{id}")
    public String updateComment(@PathVariable Long id, @RequestBody @Valid CommentRequestDto requestDto, BindingResult bindingResult){
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return  bindingResult.getFieldError().getDefaultMessage();
        } else {
        commentService.updateComment(id,requestDto);
        return "성공 했습니다";
        }
    }

    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable Long id,@RequestBody @Valid CommentRequestDto requestDto, BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return bindingResult.getFieldError().getDefaultMessage();
        } else {
            commentService.deleteComment(id, requestDto);
            return "성공 했습니다";

        }
    }

//    public boolean checkValue(@Valid CommentRequestDto requestDto,BindingResult bindingResult){
//        boolean result = false;
//        if(bindingResult.hasErrors()) {}
//
//    }
}
