package onthego.demo.service;

import lombok.RequiredArgsConstructor;
import onthego.demo.dto.ScheduleRequest;
import onthego.demo.entity.Schedule;
import onthego.demo.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class ScheduleService {
    
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Schedule createSchedule(ScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setDate(request.getDate());
        schedule.setLocation(request.getLocation());
        schedule.setDescription1(request.getDescription1());
        schedule.setDescription2(request.getDescription2());
        schedule.setDescription3(request.getDescription3());
        
        return scheduleRepository.save(schedule);
    }
}