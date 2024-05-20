package org.sparta.schedule.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.sparta.schedule.ScheduleError;
import org.sparta.schedule.dto.ScheduleRequestDto;
import org.sparta.schedule.dto.ScheduleResponseDto;
import org.sparta.schedule.entity.Schedule;
import org.sparta.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@Service
@Transactional
public class ScheduleService {
    @PersistenceContext
    EntityManager em;


    private final ScheduleRepository scheduleRepository;


    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public List<ScheduleResponseDto> getSchedule() {
        return scheduleRepository.findAllByOrderByWriteDateDesc().stream().map(ScheduleResponseDto::new).toList();
    }
    @Transactional
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
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);

        boolean haspasswd = StringUtils.hasLength(requestDto.getPasswd());//null 일경우 false 반환
        boolean checkpasswd = schedule.getPasswd().equals(requestDto.getPasswd());

        if(haspasswd&&checkpasswd){
            schedule.update(requestDto);
        return id;
        } else {
            throw new IllegalArgumentException("Wrong password");
        }
    }

    @Transactional
    @ExceptionHandler(ScheduleError.class)
    public Long deleteMemo(Long id ,ScheduleRequestDto requestDto) {

        Schedule schedule  = findSchedule(id);
        System.out.println(schedule.getPasswd());

       if(schedule.getPasswd().equals(requestDto.getPasswd())) {
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
