package onthego.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClothesResponse {
    private String top;
    private String bottom;
    private String outer;
    private String accessories;
    private String preparation; // 준비물
}
