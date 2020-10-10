package org.exampledriven;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.Factory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringBootThriftExampleApplicationServer {

    public static void main(String[] args) {

        log.info("My First Apache Shiro Application");

        //1.
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2.
        SecurityManager securityManager = factory.getInstance();

        //3.
        SecurityUtils.setSecurityManager(securityManager);

//        System.exit(0);

        SpringApplication.run(SpringBootThriftExampleApplicationServer.class, args);
    }
}
