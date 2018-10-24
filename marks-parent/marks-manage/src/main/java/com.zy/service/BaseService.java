package com.zy.service;


import com.zy.dao.common.BaseDao;

import javax.annotation.Resource;

public  abstract class BaseService {
    @Resource
    public BaseDao daoService;
}
