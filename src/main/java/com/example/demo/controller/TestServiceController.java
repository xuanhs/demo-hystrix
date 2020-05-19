package com.example.demo.controller;

import com.example.demo.api.TestServerApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController implements TestServerApi {
    @Override
    public String normal(@Validated Integer id) {
        return "成功:" + id;
    }

    @Override
    public String timeOut(@Validated Integer id) {
        int k  = 0;
        int i = 10/k;
        return "成功:" + id;
    }
}
