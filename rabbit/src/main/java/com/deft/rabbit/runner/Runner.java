package com.deft.rabbit.runner;

import java.util.concurrent.TimeUnit;

import com.deft.rabbit.MessagingRabbitmqApplication;
import com.deft.rabbit.config.RabbitConfig;
import com.deft.rabbit.producer.Tut1Sender;
import com.deft.rabbit.reciever.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Golitsyn
 * created on 29.11.2021
 */

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext ctx;

    /**
     * test messages are sent by a CommandLineRunner,
     * which also waits for the latch in the receiver and closes the application context
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready ... running for " + 10000 + "ms");
        Thread.sleep(10000);
        ctx.close();
    }

}
