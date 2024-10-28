package onthego.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
