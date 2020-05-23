package com.example.demo.api;

import com.example.demo.fallback.ServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "demo-hystrix", fallbackFactory = ServiceFallbackFactory.class)
public interface TestServiceFactoryApi {

    @PostMapping("/2/normal")
    String normal(@RequestBody @Validated Integer id);

    @PostMapping("/2/timeOut")
    String timeOut(@RequestBody @Validated Integer id);

    @PostMapping("/2/exception")
    String exception(@RequestBody @Validated Integer id);
}
