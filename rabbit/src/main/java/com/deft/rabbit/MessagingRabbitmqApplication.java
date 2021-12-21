package com.deft.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sergey Golitsyn
 * created on 29.11.2021
 */

@SpringBootApplication
public class MessagingRabbitmqApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MessagingRabbitmqApplication.class, args).close();
    }

}
