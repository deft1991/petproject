package com.example.third;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleApp")
public class WebController3 {

    @GetMapping("/helloAppThird")
    public String helloAppTwo() {
        return "hello from app third";
    }

}
