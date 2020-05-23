package com.example.demo.config;

import com.example.demo.api.TestServerApi;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

@Configuration
public class FeignHasHystrixConfigure {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        //返回HystrixFeign.Builder Feign默认支持Hystrix
        return HystrixFeign.builder().setterFactory(new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                return HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(TestServerApi.class.getSimpleName()))// 控制 RemoteProductService 下,所有方法的Hystrix Configuration
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000) // 超时配置
                        );
            }
        });
    }
}