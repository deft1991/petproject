package com.deft.petproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergey Golitsyn
 * created on 24.09.2020
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String sayHello() {
        return "Hello";
    }
}
