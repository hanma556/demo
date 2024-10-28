package onthego.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequest {
    private String date;
    private String location;
    private String description1;
    private String description2;
    private String description3;
}