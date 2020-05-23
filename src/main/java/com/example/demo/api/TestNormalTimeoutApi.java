package com.example.demo.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "demo-hystrix")
public interface TestNormalTimeoutApi {

    @PostMapping("/normal/timeOut")
    String timeOut(@RequestBody @Validated Integer id);

}
