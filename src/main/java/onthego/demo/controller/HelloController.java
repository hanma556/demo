package onthego.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import onthego.demo.dto.AlarmRequest;
import onthego.demo.dto.ClothesResponse;
import onthego.demo.dto.ScheduleRequest;
import onthego.demo.dto.WeatherRequest;
import onthego.demo.service.ClothingRecommendationService;
import onthego.demo.service.ScheduleService;
import onthego.demo.entity.Schedule;
import java.util.List;
import onthego.demo.service.AlarmService;
import onthego.demo.entity.Alarm;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloController {

    private final ClothingRecommendationService clothesService;
    private final ScheduleService scheduleService;
    private final AlarmService alarmService;

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
    public ResponseEntity<List<Schedule>> getAllSchedules() {
         List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    // 일정 추가
    @PostMapping("/schedule")
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleRequest request) {
        Schedule savedSchedule = scheduleService.createSchedule(request);
        return ResponseEntity.ok(savedSchedule);
    }

    // 날씨 정보 조회
    @GetMapping("/weather")
    public Map<String, Object> getWeather() {
        Map<String, Object> response = new HashMap<>();

        // 더미 데이터 설정
        response.put("location", "경기도 안양시");
        response.put("temperature", "15.86°C");
        response.put("humidity", "67%");

        return response;
    }

    // 의류 정보 조회
    // @GetMapping("/clothes")
    // public Map<String, String> getClothes() {
    // Map<String, String> response = new HashMap<>();

    // // 더미 데이터 설정
    // response.put("top", "티셔츠");
    // response.put("bottom", "청바지");
    // response.put("outer", "자켓");
    // response.put("accessories", "모자");

    // return response;
    // }

    // 날씨에 따른 옷, 물품 정보 내려보내줌
    @PostMapping("/clothes")
    public ClothesResponse Clothes(@RequestBody WeatherRequest request) {
        return clothesService.getRecommendedClothes(request);
    }

    // @GetMapping("/preparation")
    // public Map<String, String> getPreparationItem() {
    // Map<String, String> response = new HashMap<>();
    // response.put("result", "마스크");
    // // 단일 준비물 응답 설정
    // return response;
    // }

    // 알람 생성
    @PostMapping("/alarm")
    public ResponseEntity<Alarm> createAlarm(@RequestBody AlarmRequest request) {
        Alarm savedAlarm = alarmService.createAlarm(request);
        return ResponseEntity.ok(savedAlarm);
    }

    // 알람 수정
    @PutMapping("/alarm/{id}")
    public ResponseEntity<Alarm> updateAlarm(
            @PathVariable Long id,
            @RequestBody AlarmRequest request) {
        Alarm updatedAlarm = alarmService.updateAlarm(id, request);
        return ResponseEntity.ok(updatedAlarm);
    }

    // 첫번째 알람 조회
    @GetMapping("/alarm")
    public ResponseEntity<Alarm> getFirstAlarm() {
        Alarm alarm = alarmService.getFirstAlarm();
        return ResponseEntity.ok(alarm);
    }



}
