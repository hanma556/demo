package onthego.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onthego.demo.dto.AlarmRequest;
import onthego.demo.dto.ScheduleRequest;
import onthego.demo.dto.WeatherRequest;

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
        response.put("location", "홍라드");
        response.put("description1", "사진 촬영");
        response.put("description2", "카페 탐방");
        response.put("description3", "쇼핑");

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
    public Map<String, String> Clothes(@RequestBody WeatherRequest request) {
        Map<String, String> response = new HashMap<>();

        // 더미 데이터 설정
        response.put("top", "티셔츠");
        response.put("bottom", "청바지");
        response.put("outer", "자켓");
        response.put("accessories", "모자");
        response.put("result", "마스크");

        return response;
    }

    // @GetMapping("/preparation")
    // public Map<String, String> getPreparationItem() {
    // Map<String, String> response = new HashMap<>();
    // response.put("result", "마스크");
    // // 단일 준비물 응답 설정
    // return response;
    // }

    @PostMapping("/alarm")
    public Map<String, String> setAlarm(@RequestBody AlarmRequest request) {
        Map<String, String> response = new HashMap<>();

        // 요청 받은 알람 시간 설정
        response.put("alarmTime", request.getAlarmTime());

        return response;
    }

}
