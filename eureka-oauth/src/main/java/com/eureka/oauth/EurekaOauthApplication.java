package com.eureka.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOauthApplication.class, args);
    }

}
