package com.example.demo.api;

import com.example.demo.fallback.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "demo-hystrix", fallback = TestServiceFallback.class)
public interface TestServerApi {


    @PostMapping("/normal")
    String normal(Integer id);


    @PostMapping("/timeOut")
    String timeOut(Integer id);
}
