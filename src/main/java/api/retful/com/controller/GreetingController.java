package api.retful.com.controller;

import api.retful.com.dto.GreetingDTO;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String templat = "Hello, %s!";
    private static final AtomicInteger conter = new AtomicInteger();
    @GetMapping
    public GreetingDTO greeting(@RequestParam(value="name",defaultValue = "World")String name) {
       return new GreetingDTO(conter.incrementAndGet(),String.format(templat,name));
    }
}
