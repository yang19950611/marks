package com.zy.dao.mapper;

import com.zy.dao.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}