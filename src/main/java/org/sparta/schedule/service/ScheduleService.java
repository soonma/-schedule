package org.sparta.schedule.service;

import org.sparta.schedule.dto.ScheduleRequestDto;
import org.sparta.schedule.dto.ScheduleResponseDto;
import org.sparta.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public static List<ScheduleResponseDto> getMemos() {
        return null;
    }

    public ScheduleResponseDto createSchedule() {
        return null;
    }

    public Long updateMemo(Long id, ScheduleRequestDto requestDto) {
        return null;
    }

    public String deleteMemo(String title,String passwd) {
        return null;
    }
}
