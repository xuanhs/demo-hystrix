package com.example.demo.fallback;

import com.example.demo.api.TestServerApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestServiceFallback implements TestServerApi {

    @Override
    public String normal(Integer id) {
        return "熔断：" + id;
    }

    @Override
    public String timeOut(Integer id) {
        return "熔断：" + id;
    }

    @Override
    public String exception(Integer id) {
        return "熔断：" + id;
    }

    @Override
    public String exceptionNPL(Integer id) {
        return "熔断：" + id;
    }
}
