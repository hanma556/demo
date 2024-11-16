package onthego.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import onthego.demo.dto.AlarmRequest;
import onthego.demo.entity.Alarm;
import onthego.demo.repository.AlarmRepository;

// 알람과 관련된 비즈니스 로직을 처리하는 서비스 클래스
@Service
@RequiredArgsConstructor
public class AlarmService {

    // AlarmRepository 인스턴스를 생성자를 통해 주입받음
    private final AlarmRepository alarmRepository;

    // 새로운 알람을 생성하는 메서드
    // @param request 알람 시간 등의 정보를 포함한 요청 객체
    // @return 생성된 Alarm 엔티티
    @Transactional
    public Alarm createAlarm(AlarmRequest request) {
        Alarm alarm = new Alarm(); // 새로운 Alarm 인스턴스 생성
        alarm.setAlarmTime(request.getAlarmTime()); // 요청 객체에서 알람 시간 설정
        return alarmRepository.save(alarm); // 알람 저장 후 반환
    }

    // 특정 알람을 수정하는 메서드
    // @param id 수정할 알람의 ID
    // @param request 수정할 정보를 포함한 요청 객체
    // @return 수정된 Alarm 엔티티
    @Transactional
    public Alarm updateAlarm(Long id, AlarmRequest request) {
        Alarm alarm = alarmRepository.findById(id) // ID로 알람 조회
                .orElseThrow(() -> new RuntimeException("알람을 찾을 수 없습니다")); // 없을 경우 예외 발생

        alarm.setAlarmTime(request.getAlarmTime()); // 알람 시간 업데이트
        return alarmRepository.save(alarm); // 수정된 알람 저장 후 반환
    }

    // 모든 알람을 조회하는 메서드
    // @return 저장된 모든 알람의 리스트
    @Transactional(readOnly = true)
    public List<Alarm> getAllAlarms() {
        return alarmRepository.findAll(); // 모든 알람 조회
    }

    // 특정 ID의 알람을 조회하는 메서드
    // @param id 조회할 알람의 ID
    // @return 조회된 Alarm 엔티티
    @Transactional(readOnly = true)
    public Alarm getAlarm(Long id) {
        return alarmRepository.findById(id) // ID로 알람 조회
                .orElseThrow(() -> new RuntimeException("알람을 찾을 수 없습니다")); // 없을 경우 예외 발생
    }

    // 가장 먼저 생성된 알람을 조회하는 메서드
    // @return 가장 오래된 Alarm 엔티티
    @Transactional(readOnly = true)
    public Alarm getFirstAlarm() {
        return alarmRepository.findFirstByOrderByIdAsc(); // 가장 먼저 생성된 알람 조회
    }
}
