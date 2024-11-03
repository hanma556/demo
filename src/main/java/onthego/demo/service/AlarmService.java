package onthego.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import onthego.demo.repository.AlarmRepository;
import onthego.demo.entity.Alarm;
import onthego.demo.dto.AlarmRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;

    @Transactional
    public Alarm createAlarm(AlarmRequest request) {
        Alarm alarm = new Alarm();
        alarm.setAlarmTime(request.getAlarmTime());
        return alarmRepository.save(alarm);
    }

    @Transactional
    public Alarm updateAlarm(Long id, AlarmRequest request) {
        Alarm alarm = alarmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alarm not found"));
        
        alarm.setAlarmTime(request.getAlarmTime());
        return alarmRepository.save(alarm);
    }

    @Transactional(readOnly = true)
    public List<Alarm> getAllAlarms() {
        return alarmRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Alarm getAlarm(Long id) {
        return alarmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alarm not found"));
    }

    @Transactional(readOnly = true)
    public Alarm getFirstAlarm() {
        return alarmRepository.findFirstByOrderByIdAsc();
    }
}
