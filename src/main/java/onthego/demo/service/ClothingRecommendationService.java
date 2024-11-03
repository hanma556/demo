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
        if (temperature >= 28) {
            top = "민소매";
            bottom = "숏팬츠";
            outer = "없음";
            accessories = "샌들";
            preparation = "양산";
        } else if (temperature <= 27 && temperature >= 23) {
            top = "반팔";
            bottom = "반바지";
            outer = "없음";
            accessories = "샌들";
            preparation = "부채";
        } else if (temperature <= 22 && temperature >= 20) {
            top = "셔츠";
            bottom = "슬랙스";
            outer = "얇은 가디건";
            accessories = "운동화";
            preparation = "손수건";
        } else if (temperature <= 19 && temperature >= 17) {
            top = "후드";
            bottom = "청바지";
            outer = "바람막이";
            accessories = "운동화";
            preparation = "스카프";
        } else if (temperature <= 16 && temperature >= 12) {
            top = "니트";
            bottom = "청바지";
            outer = "가디건";
            accessories = "스니커즈";
            preparation = "마스크";
        } else if (temperature <= 11 && temperature >= 9) {
            top = "니트";
            bottom = "기모바지";
            outer = "트렌치코트";
            accessories = "비니";
            preparation = "담요";
        } else if (temperature <= 8 && temperature >= 5) {
            top = "기모 후드";
            bottom = "기모바지";
            outer = "코트";
            accessories = "어그 부츠";
            preparation = "핸드크림";
        } else {
            top = "기모 후드";
            bottom = "기모바지";
            outer = "패딩";
            accessories = "목도리";
            preparation = "핫팩";
        }

        // 날씨에 따라 추가 조정
        if (weather.contains("비")) {
            preparation += ", 우비, 우산";
        } else if (weather.contains("눈")) {

            preparation += ", 보온병";
        }

        return new ClothesResponse(top, bottom, outer, accessories, preparation);
    }
}
