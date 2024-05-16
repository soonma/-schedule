package org.sparta.schedule.dto;

import lombok.Getter;
import org.sparta.schedule.entity.Schedule;
import java.time.LocalDateTime;


@Getter

public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String titleContent;
    private String manager;
    private String passwd;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.titleContent = schedule.getTitleContent();
        this.manager = schedule.getManager();
        this.passwd = schedule.getPasswd();
//        this.writeDate= schedule.getWriteDate();
//        this.updateDate= schedule.getUpdateDate();

    }

}
