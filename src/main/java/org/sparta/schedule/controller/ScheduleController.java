package org.sparta.schedule.controller;



import io.swagger.v3.oas.annotations.tags.Tags;
import org.sparta.schedule.dto.ScheduleRequestDto;
import org.sparta.schedule.dto.ScheduleResponseDto;
import org.sparta.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@Tags
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping("/schedule")//클라이언트의 요청 데이터(Request Body)를 서버에 생성할 때 사용
    public ScheduleResponseDto create(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule")//요청받은 URL 정보를 검색하여 응답한다
    public List<ScheduleResponseDto> getSchedule() {
        return scheduleService.getSchedule();
    }

    @GetMapping("/schedule/{id}")//요청받은 URL 정보를 검색하여 응답한다
    public ScheduleResponseDto getDetailSchedule(@PathVariable Long id) {
        return scheduleService.getDetailSchedule(id);
    }

    @PutMapping("/schedule/{id}") //요청된 자원을 수정한다.
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id,requestDto);
    }

    @DeleteMapping("/schedule/{id}") //요청된 자원을 삭제 할때 사용
    public Long deleteSchedule(@PathVariable(required = false) Long id,@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.deleteMemo(id,requestDto);
    }

}
