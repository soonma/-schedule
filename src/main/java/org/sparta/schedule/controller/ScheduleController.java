package org.sparta.schedule.controller;

import org.sparta.schedule.dto.ScheduleRequestDto;
import org.sparta.schedule.dto.ScheduleResponseDto;
import org.sparta.schedule.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;


    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/write")//클라이언트의 요청 데이터(Request Body)를 서버에 생성할 때 사용
    public ScheduleResponseDto createMemo(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule();
    }

    @GetMapping("/selectAll")//요청받은 URL 정보를 검색하여 응답한다
    public List<ScheduleResponseDto> getSchedule() {
        return scheduleService.getMemos();
    }

    @PutMapping("/memos/{id}") //요청된 자원을 수정한다.
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateMemo(id,requestDto);
    }

    @DeleteMapping("/memos/{id}") //요청된 자원을 삭제 할때 사용
    public String deleteSchedule(@RequestParam(required = false) String title, String passwd) {
        return scheduleService.deleteMemo(title,passwd);
    }

}
