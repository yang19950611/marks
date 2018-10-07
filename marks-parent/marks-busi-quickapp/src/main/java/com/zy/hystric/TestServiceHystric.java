package com.zy.hystric;

import com.zy.feign.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceHystric implements TestService {

    @Override
    public String testHy() {
        return "服务异常";
    }
}
