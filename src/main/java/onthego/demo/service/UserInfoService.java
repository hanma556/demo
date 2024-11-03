package onthego.demo.service;

import lombok.RequiredArgsConstructor;
import onthego.demo.dto.UserInfoRequest;
import onthego.demo.entity.UserInfo;
import onthego.demo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    
    private final UserInfoRepository userInfoRepository;

    @Transactional
    public UserInfo updateUserInfo(UserInfoRequest request) {
        UserInfo userInfo = userInfoRepository.findFirstByOrderByIdAsc()
            .orElseGet(UserInfo::new);
        
        if (request.getLocationEnabled() != null) {
            userInfo.setLocationEnabled(request.getLocationEnabled());
        }
        
        if (request.getNotificationEnabled() != null) {
            userInfo.setNotificationEnabled(request.getNotificationEnabled());
        }
        
        return userInfoRepository.save(userInfo);
    }

    @Transactional(readOnly = true)
    public UserInfo getUserInfo() {
        return userInfoRepository.findFirstByOrderByIdAsc()
            .orElseGet(UserInfo::new);
    }
} 