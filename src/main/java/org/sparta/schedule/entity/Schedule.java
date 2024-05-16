package org.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.schedule.dto.ScheduleRequestDto;


@Entity
@Getter
@Setter
@Table(name = "schedule") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String titleContent;

    @Column
    private String manager;

    @Column
    private String passwd;

    public Schedule(ScheduleRequestDto requestDto){

        this.title = requestDto.getTitle();
        this.titleContent = requestDto.getTitleContent();
        this.manager = requestDto.getManager();
        this.passwd = requestDto.getPasswd();
    }

}
