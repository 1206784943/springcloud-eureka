package com.eureka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomerApplication.class, args);
    }

    //向spring里注入一个RestTemplate对象
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
