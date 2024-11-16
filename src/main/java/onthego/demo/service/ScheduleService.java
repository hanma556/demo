package onthego.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import onthego.demo.dto.ScheduleRequest;
import onthego.demo.entity.Schedule;
import onthego.demo.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository; // ScheduleRepository 주입

    // 스케줄 생성 메서드
    @Transactional
    public Schedule createSchedule(ScheduleRequest request) {
        Schedule schedule = new Schedule(); // 새 스케줄 객체 생성
        schedule.setDate(request.getDate()); // 날짜 설정
        schedule.setLocation(request.getLocation()); // 위치 설정
        schedule.setDescription1(request.getDescription1()); // 설명1 설정
        schedule.setDescription2(request.getDescription2()); // 설명2 설정
        schedule.setDescription3(request.getDescription3()); // 설명3 설정

        return scheduleRepository.save(schedule); // 저장 후 반환
    }

    // 모든 스케줄 조회 메서드
    @Transactional(readOnly = true)
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll(); // 모든 스케줄 반환
    }
}
