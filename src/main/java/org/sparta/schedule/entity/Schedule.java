package org.sparta.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.schedule.dto.ScheduleRequestDto;


@Entity
@Getter
@Setter
@Table(name = "schedule") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Schedule extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "titleContent")
    private String titleContent;

    @Column(name = "manager")
    private String manager;

    @Column(name = "passwd")
    private String passwd;

    public Schedule(ScheduleRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.titleContent = requestDto.getTitleContent();
        this.manager = requestDto.getManager();
        this.passwd = requestDto.getPasswd();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.titleContent = requestDto.getTitleContent();
        this.manager = requestDto.getManager();
        this.passwd = requestDto.getPasswd();
    }
}
