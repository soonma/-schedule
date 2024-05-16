package org.sparta.schedule.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.sparta.schedule.dto.ScheduleRequestDto;
import org.sparta.schedule.dto.ScheduleResponseDto;
import org.sparta.schedule.entity.Schedule;
import org.sparta.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Component
public class ScheduleService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public List<ScheduleResponseDto> getSchedule() {
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);
        // DB 저장
        Schedule savaSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;

    }

    public Long updateMemo(Long id, ScheduleRequestDto requestDto) {
        return null;
    }

    public String deleteMemo(String title,String passwd) {
        return null;
    }

    public Long getLogin(Long id, String passwd) {
        return null;
    }
}
