package com.example.demo.controller;

import com.example.demo.api.TestServiceFactoryApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceFactoryController implements TestServiceFactoryApi {
    @Override
    public String normal(@RequestBody @Validated Integer id) {
        return "正常" + id;
    }

    @Override
    public String timeOut(@RequestBody @Validated Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "正常" + id;
    }

    @Override
    public String exception(@RequestBody @Validated Integer id) {
        int k = 0;
        int i = 10 / k;
        return "正常" + id;
    }
}
