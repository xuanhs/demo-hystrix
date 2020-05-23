package com.example.demo.fallback;

import com.example.demo.api.TestServiceFactoryApi;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServiceFallbackFactory implements FallbackFactory<TestServiceFactoryApi> {

    @Override
    public TestServiceFactoryApi create(Throwable throwable) {
        log.error("服务发生熔断啦，原因：{},{}", throwable.getMessage());
        return new TestServiceFactoryApi() {
            @Override
            public String normal(Integer id) {
                return "熔断" + id;
            }

            @Override
            public String timeOut(Integer id) {
                return "熔断" + id;
            }

            @Override
            public String exception(Integer id) {
                return "熔断" + id;
            }
        };
    }
}
