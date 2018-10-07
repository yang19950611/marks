package com.zy.feign;

import com.zy.hystric.TestServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-feign-test",fallback = TestServiceHystric.class)
public interface TestService {

    @RequestMapping(value = "/test/testHy")
    String testHy();
}
