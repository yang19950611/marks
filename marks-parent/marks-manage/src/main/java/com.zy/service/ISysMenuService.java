package com.zy.service;

import com.zy.dto.out.sys.SysMenuDto;

import java.util.List;

public interface ISysMenuService {
    List<SysMenuDto> getMenu(String userName);
}
