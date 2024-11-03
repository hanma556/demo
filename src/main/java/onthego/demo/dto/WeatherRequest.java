package onthego.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherRequest {
    private String weather; // 날씨 정보
    private int temperature; // 기온 정보
}
