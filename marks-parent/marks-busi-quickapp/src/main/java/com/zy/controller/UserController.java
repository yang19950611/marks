package com.zy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zy.dao.po.UserInfo;
import com.zy.feign.TestService;
import com.zy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
@Api(description = "用户接口")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TestService testService;


    /**
     * 测试
     */
    @RequestMapping("/getUserInfo")
    @ApiOperation(value = "获取用户信息" ,  notes=" 获取用户信息")
    public UserInfo getUser(HttpServletRequest request) {
        logger.info("获取用户信息");
        kafkaTemplate.send("first-test","key","hello world!");
        return userService.getUserInfoByPhone();
    }

    @RequestMapping("/testRibbon")
    @HystrixCommand(fallbackMethod = "commErr")
    public String tetsRibbon(HttpServletRequest request){
        String forObject = restTemplate.getForObject("http://service-ribbon-test/test/testHy", String.class);
        logger.info("获取结果:"+forObject);
        return forObject;
    }

    public String commErr(HttpServletRequest request) {
        return "服务异常";
    }

    @RequestMapping("/testFeign")
    public String testFeign(HttpServletRequest request){
        String str = testService.testHy();
        logger.info("获取结果:"+str);
        return str;
    }
}
