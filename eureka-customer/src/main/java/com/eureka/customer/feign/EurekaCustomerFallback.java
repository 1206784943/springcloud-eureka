package com.eureka.customer.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaCustomerFallback implements FallbackFactory<EurekaCustomerFeign> {

    private static final Logger logger = LoggerFactory.getLogger(EurekaCustomerFallback.class);

    @Override
    public EurekaCustomerFeign create(Throwable throwable) {
        return new EurekaCustomerFeign() {
            @Override
            public String getDemoInfo() {
                logger.error(throwable.getMessage());
                return null;
            }
        };
    }
}
