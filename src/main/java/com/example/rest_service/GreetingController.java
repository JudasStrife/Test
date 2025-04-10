
package com.example.rest_service;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {

    public record Greeting(long id, String content){}
    private static final String template = "Hello, %s and %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("hello")
    public Greeting greeting (@RequestParam(value = "name", defaultValue="World") String name ){
        return new Greeting(counter.incrementAndGet(), String.format(template, name, name));
    }
}
