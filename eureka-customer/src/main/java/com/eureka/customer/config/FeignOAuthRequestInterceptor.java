package com.eureka.customer.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class FeignOAuthRequestInterceptor implements RequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignOAuthRequestInterceptor.class);

    /**
     * 当 Hystrix的默认隔离策略是THREAD时，不能通过RequestContextHolder获取到request对象
     * 将隔离策略改为SEMAPHORE 也可以解决这个问题，但是官方并不推荐这个策略，因为这个策略对网络资源消耗比较大
     * 解决：自定义并发策略 FeignConfig
     * 将现有的并发策略作为新并发策略的成员变量
     * 在新并发策略中，返回现有并发策略的线程池、Queue
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("Authorization");
        requestTemplate.header("Authorization", token);

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
//        requestTemplate.header("Authorization", details.getTokenValue());

    }

}


