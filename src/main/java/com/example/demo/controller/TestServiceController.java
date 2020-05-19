package com.example.demo.controller;

import com.example.demo.api.TestServerApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController implements TestServerApi {
    @Override
    public String normal(Integer id) {
        return "成功:" + id;
    }

    @Override
    public String timeOut(Integer id) {
        return "成功:" + id;
    }
}
