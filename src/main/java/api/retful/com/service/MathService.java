package api.retful.com.service;

import api.retful.com.dto.NumbersInputDTO;
import api.retful.com.exceptions.MathException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MathService {

    public double calculator(NumbersInputDTO inputDTO) {
        validateOperation(inputDTO.getOperationName());
        double result = 0.0;

        switch (inputDTO.getOperationName()) {
            case "Multiplication" -> {
                result = multiplication(inputDTO);
                return result;
            }
            case "Media" -> {
                result = media(inputDTO);
                return result;
            }
            case "Division" -> {
                result = division(inputDTO);
                return result;
            }
            case "Subtraction" -> {
                result =  subtraction(inputDTO);
                return result;
            }
            case "Square root" -> {
                result =  squareRoot(inputDTO);
                return result;
            }
        }
        return result;
    }

    public double media(NumbersInputDTO inputDTO){
        double numbers = Arrays.stream(inputDTO.getMedia()).sum();
        return numbers / inputDTO.getMedia().length;
    }

    public double multiplication(NumbersInputDTO inputDTO){
        return inputDTO.getNumber() * inputDTO.getSecondNumber();
    }

    public double division(NumbersInputDTO inputDTO){
        return inputDTO.getNumber() / inputDTO.getSecondNumber();
    }

    public double subtraction(NumbersInputDTO inputDTO){
        return inputDTO.getNumber() + inputDTO.getSecondNumber();
    }

    public double squareRoot(NumbersInputDTO inputDTO){
        return Math.sqrt(inputDTO.getNumber());
    }

    public void validateOperation(String operation) {
        Set<String> validOperations = new HashSet<>(Arrays.asList("Multiplication", "Division", "Subtraction", "Media","Square root"));
        boolean isValid = validOperations.contains(operation);

        if(!isValid) {
            throw new MathException("Invalid operation name: " + operation);
        }
    }

}
