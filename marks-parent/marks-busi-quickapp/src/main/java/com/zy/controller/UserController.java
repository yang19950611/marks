package com.zy.controller;

import com.zy.dao.po.UserInfo;
import com.zy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
@Api(description = "用户接口")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    /**
     * 测试
     */
    @RequestMapping("/getUserInfo")
    @ApiOperation(value = "获取用户信息" ,  notes=" 获取用户信息")
    public UserInfo getUser(HttpServletRequest request) {
        logger.info("获取用户信息");
        return userService.getUserInfoByPhone();
    }
}
