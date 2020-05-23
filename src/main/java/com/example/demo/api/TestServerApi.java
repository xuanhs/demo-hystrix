package com.example.demo.api;

import com.example.demo.config.FeignHasHystrixConfigure;
import com.example.demo.fallback.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "demo-hystrix",configuration = FeignHasHystrixConfigure.class,fallback = TestServiceFallback.class)
public interface TestServerApi {

    @PostMapping("/normal")
    String normal(@RequestBody @Validated Integer id);

    @PostMapping("/timeOut")
    String timeOut(@RequestBody @Validated Integer id);

    @PostMapping("/exception")
    String exception(@RequestBody @Validated Integer id);

    @PostMapping("/exceptionNPL")
    String exceptionNPL(@RequestBody @Validated Integer id);
}
