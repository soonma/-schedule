package org.sparta.schedule;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.schedule.entity.Schedule;
import org.sparta.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ScheduleApplicationTests {
    @PersistenceContext
    EntityManager em;

    @Autowired
    ScheduleRepository scheduleRepository;
    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("데이터 생성 성공")
    void test1() {
        Schedule schedule = new Schedule();
        schedule.setId("fltnsah");
        schedule.setPasswd("1q2w3e4r");
        schedule.setManager("??");
        schedule.setTitleContent("테스트 중입니다.");
        schedule.setTitle("test");

        em.persist(schedule);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }
}
