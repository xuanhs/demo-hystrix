package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestNormalTimeoutController implements com.example.demo.api.TestNormalTimeoutApi {


    @Override
    public String timeOut(Integer id) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }
}
