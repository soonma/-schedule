package org.sparta.schedule.dto;

import lombok.Getter;
import org.sparta.schedule.entity.Schedule;



@Getter

public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String titleContent;
    private String manager;
    private String writeDate;
    private String updateDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.titleContent = schedule.getTitleContent();
        this.manager = schedule.getManager();
        this.writeDate= schedule.getWriteDate();
        this.updateDate= schedule.getUpdateDate();
    }
}
