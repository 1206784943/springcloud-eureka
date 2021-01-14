package com.eureka.customer.controller;

import com.eureka.customer.feign.EurekaCustomerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaCustomerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaCustomerFeign eurekaCustomerFeign;



    @RequestMapping("/test5")
    public String test3() {
        return "this is a customer service";
    }

    /**
     * feign功能测试
     * @return
     */
    @RequestMapping("/test4")
    public String test4() {
        String demoInfo = eurekaCustomerFeign.getDemoInfo();
        return demoInfo;
    }

    @RequestMapping("/test1")
    public String getEurekaServiceInfo() {
        String url = "http://localhost:8081/getInfo";
        HttpMethod type = HttpMethod.GET;
        RequestEntity<String> paras = null;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, type, paras, String.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/test2")
    public String getString1() {
        //getForObject 调用无参方法，返回结果为String的方法
        String url = "http://localhost:8081/getInfo";
        String res = restTemplate.getForObject(url, String.class);
        return res;
    }

    @RequestMapping("/test3")
    public String getString2() {
        //getForObject 调用有参方法，路径添加参数。返回结果为String的方法
        String url = "http://localhost:8081/getString?userId=sn001";
        String res = restTemplate.getForObject(url, String.class);
        return res;
    }

}
