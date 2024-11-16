package onthego.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import onthego.demo.dto.UserInfoRequest;
import onthego.demo.entity.UserInfo;
import onthego.demo.repository.UserInfoRepository;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository; // UserInfoRepository 주입

    // 사용자 정보를 업데이트하는 메서드
    @Transactional
    public UserInfo updateUserInfo(UserInfoRequest request) {
        // 첫 번째 사용자 정보 조회, 없으면 새 객체 생성
        UserInfo userInfo = userInfoRepository.findFirstByOrderByIdAsc()
                .orElseGet(UserInfo::new);

        // 위치 권한 정보 업데이트
        if (request.getLocationEnabled() != null) {
            userInfo.setLocationEnabled(request.getLocationEnabled());
        }

        // 알림 권한 정보 업데이트
        if (request.getNotificationEnabled() != null) {
            userInfo.setNotificationEnabled(request.getNotificationEnabled());
        }

        return userInfoRepository.save(userInfo); // 수정된 정보 저장 후 반환
    }

    // 사용자 정보를 조회하는 메서드
    @Transactional(readOnly = true)
    public UserInfo getUserInfo() {
        // 첫 번째 사용자 정보 조회, 없으면 새 객체 생성
        return userInfoRepository.findFirstByOrderByIdAsc()
                .orElseGet(UserInfo::new);
    }
}
