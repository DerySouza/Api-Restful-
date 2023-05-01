package api.retful.com.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumbersInputDTO {
    private double number;
    private double secondNumber;
    private String operationName;
    private double[] media;
}
