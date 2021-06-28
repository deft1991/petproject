package com.example.multi;

import com.example.second.SecondApplication;
import com.example.third.ThirdApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{MultiApplication.class, SecondApplication.class, ThirdApplication.class},
                args);
    }

}
