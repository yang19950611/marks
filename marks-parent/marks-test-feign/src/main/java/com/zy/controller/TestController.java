package com.zy.controller;

import com.zy.inter.UserInfoInter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    UserInfoInter userInfoInter;
    /**
     * 测试
     */
    @RequestMapping("/test")
    public String getUser(HttpServletRequest request) {
        String forObject = userInfoInter.getUserInfo();
        logger.info("获取结果:"+forObject);
        logger.info("test----------------");
        return "";
    }

    @RequestMapping("/testHy")
    public String testFeign(HttpServletRequest request){
        logger.info("test-feign ----------------");
        return "test-feign";
    }


    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
