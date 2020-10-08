package com.deft.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2020
 */

@Controller
@RequestMapping("/hello")
public class PetController {

    @GetMapping
    public String hello() {
        return "Hello";
    }
}
