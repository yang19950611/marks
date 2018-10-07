package com.zy.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-quickapp")
public interface UserInfoInter {
    @RequestMapping(value = "/user/getUserInfo")
    String getUserInfo();
}
