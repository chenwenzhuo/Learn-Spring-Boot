package com.heythere.Spring_Boot_Hello_World;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, ConfigTestBean.class})
@SpringBootApplication
public class SpringBootHelloWorldApplication {
    /*@RequestMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldApplication.class, args);
    }
}
