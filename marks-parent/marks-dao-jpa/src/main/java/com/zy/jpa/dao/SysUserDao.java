
package com.zy.jpa.dao;

import com.zy.jpa.po.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser,Integer>{
    SysUser findByAccount(String account);

}
