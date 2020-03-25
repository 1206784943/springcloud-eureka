package com.eureka.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//rest 风格控制器
@RestController
public class EurekaProviderController {
    @RequestMapping("/getInfo")
    public String getDemoInfo() {
        return "this is a provider service";
    }

    @RequestMapping("/getString")
    public String getDemoInfo1(String userId) {
        return userId + ",this is a provider service";
    }

}
