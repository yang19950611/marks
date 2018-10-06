package com.zy.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    RestTemplate restTemplate;
    /**
     * 测试
     */
    @RequestMapping("/test")
    public String getUser(HttpServletRequest request) {
        String forObject = restTemplate.getForObject("http://service-quickapp/user/getUserInfo", String.class);
        logger.info("获取结果:"+forObject);
        logger.info("test----------------");
        return "";
    }
}
