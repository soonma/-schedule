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
import org.springframework.transaction.annotation.Transactional;

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

    public ScheduleResponseDto getDetailSchedule(Long id) {
        Schedule schedule = findSchedule(id);
        System.out.println(id);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    @Transactional
    public Long updateSchedule(Long id, String passwd, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);
        if(schedule.getPasswd().equals(passwd)){

        schedule.update(requestDto);

        return id;
        } else {
            throw new IllegalArgumentException("Wrong password");
        }
    }


    public Long deleteMemo(Long id ,String passwd) {
        Schedule schedule  = findSchedule(id);
        System.out.println(schedule.getPasswd());
        System.out.println(passwd);
       if(schedule.getPasswd().equals(passwd)) {
        // memo 삭제
        scheduleRepository.delete(schedule);
        return id;
       } else{
           throw new IllegalArgumentException("Wrong password");
       }

    }


    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
    }

}
