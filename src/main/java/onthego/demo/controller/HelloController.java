package onthego.demo.controller;

import onthego.demo.dto.ScheduleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloController {

    // 위치 허용 처리
    @PostMapping("/permissions/location/allow")
    public ResponseEntity<String> allowLocation() {
        // 위치 허용 로직 추가
        return ResponseEntity.ok("위치 허용됨.");
    }

    // 위치 거부 처리
    @PostMapping("/permissions/location/deny")
    public ResponseEntity<String> denyLocation() {
        // 거부 시 휴대폰 설정 어플로 안내하는 로직 추가
        return ResponseEntity.ok("위치 권한이 거부되었습니다. 설정에서 허용해주세요.");
    }

    // 알람 허용 처리
    @PostMapping("/permissions/alarm/allow")
    public ResponseEntity<String> allowAlarm() {
        // 알람 허용 로직 추가
        return ResponseEntity.ok("알람 허용됨.");
    }

    // 알람 거부 처리
    @PostMapping("/permissions/alarm/deny")
    public ResponseEntity<String> denyAlarm() {
        // 거부 시 휴대폰 설정 어플로 안내하는 로직 추가
        return ResponseEntity.ok("알람 권한이 거부되었습니다. 설정에서 허용해주세요.");
    }

    @GetMapping("/schedule")
    public Map<String, String> getSchedule() {
        Map<String, String> response = new HashMap<>();

        // 날짜 및 시간 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = LocalDateTime.of(2024, 1, 26, 12, 0, 0).format(formatter);

        // 더미 데이터 설정
        response.put("date", date);
        response.put("location", "경기도 안양시");
        response.put("description1", "요리하기");
        response.put("description2", "빨래개기");
        response.put("description3", "화장하기");

        return response;
    }

    // 일정 추가
    @PostMapping("/schedule")
    public Map<String, String> createSchedule(@RequestBody ScheduleRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("date", request.getDate());
        response.put("location", request.getLocation());
        response.put("description1", request.getDescription1());
        response.put("description2", request.getDescription2());
        response.put("description3", request.getDescription3());
        return response;
    }
}
