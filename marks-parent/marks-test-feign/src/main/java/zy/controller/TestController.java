package zy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zy.inter.UserInfoInter;

import javax.servlet.http.HttpServletRequest;

@RestController
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
}
