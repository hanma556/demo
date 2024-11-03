package onthego.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoRequest {
    private Boolean locationEnabled;
    private Boolean notificationEnabled;
} 