package com.example.multi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergey Golitsyn
 * created on 10.10.2020
 */
@RestController
@RequestMapping("/sampleApp")
public class WebController {

    @GetMapping("/helloApp")
    public String helloAppOne() {
        return "hello from app one";
    }

}
