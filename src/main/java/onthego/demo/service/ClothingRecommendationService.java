package onthego.demo.service;

import org.springframework.stereotype.Service;

import onthego.demo.dto.ClothesResponse;
import onthego.demo.dto.WeatherRequest;

@Service
public class ClothingRecommendationService {

    public ClothesResponse getRecommendedClothes(WeatherRequest request) {
        String weather = request.getWeather().toLowerCase();
        int temperature = request.getTemperature();

        String top;
        String bottom;
        String outer;
        String accessories;
        String preparation = "";

        // 날씨와 기온에 따라 의류 추천 로직
        if (temperature >= 30) {
            top = "반팔 티셔츠";
            bottom = "반바지";
            outer = "없음";
            accessories = "모자";
        } else if (temperature >= 20) {
            top = "티셔츠";
            bottom = "청바지";
            outer = "가디건";
            accessories = "선글라스";
        } else if (temperature >= 10) {
            top = "긴팔 티셔츠";
            bottom = "슬랙스";
            outer = "자켓";
            accessories = "목도리";
        } else {
            top = "두꺼운 스웨터";
            bottom = "따뜻한 바지";
            outer = "패딩";
            accessories = "장갑";
        }

        // 날씨에 따라 추가 조정
        if (weather.contains("비")) {
            outer += " (우산 필수)";
        } else if (weather.contains("눈")) {
            outer += " (눈에 맞는 옷)";
        }

        return new ClothesResponse(top, bottom, outer, accessories, preparation);
    }
}
