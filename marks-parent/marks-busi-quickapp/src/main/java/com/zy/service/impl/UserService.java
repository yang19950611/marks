package com.zy.service.impl;

import com.zy.dao.mapper.UserInfoMapper;
import com.zy.dao.po.UserInfo;
import com.zy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    protected StringRedisTemplate stringRedisTemplate;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByPhone() {
        return userInfoMapper.selectByPrimaryKey(1);
    }
}
