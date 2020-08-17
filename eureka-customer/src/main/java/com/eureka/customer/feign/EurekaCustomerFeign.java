package com.eureka.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "app-eureka-provider")
public interface EurekaCustomerFeign {

    @RequestMapping("/getInfo")
    String getDemoInfo();
}
