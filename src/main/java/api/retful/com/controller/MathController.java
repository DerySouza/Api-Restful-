package api.retful.com.controller;

import api.retful.com.dto.GreetingDTO;
import api.retful.com.dto.NumbersInputDTO;
import api.retful.com.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class MathController {
    private static final String templat = "Hello, %s!";
    private static final AtomicInteger conter = new AtomicInteger();

    private final MathService mathService;
    @GetMapping
    public GreetingDTO greeting(@RequestParam(value="name",defaultValue = "World")String name) {
       return new GreetingDTO(conter.incrementAndGet(),String.format(templat,name));
    }

    @PostMapping
    public ResponseEntity<?> calculation(@RequestBody NumbersInputDTO inputDTO){
        return ResponseEntity.ok().body(mathService.calculator(inputDTO));
    }

}
