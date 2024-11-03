package onthego.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_enabled")
    private Boolean locationEnabled = false;

    @Column(name = "notification_enabled")
    private Boolean notificationEnabled = false;
} 