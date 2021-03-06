package com.example.demo.controller;

import com.example.demo.api.TestServerApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController implements TestServerApi {

    @Override
    public String normal(@RequestBody @Validated Integer id) {
        return "成功:" + id;
    }


    @Override
    public String timeOut(@RequestBody @Validated Integer id) {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功:" + id;
    }

    @Override
    public String exception(@RequestBody @Validated Integer id) {
        throw new NullPointerException();
    }

    @Override
    public String exceptionNPL(@RequestBody @Validated Integer id) {
        int k = 0;
        int i = 10 / k;
        return "成功:" + id;
    }
}
