package com.zy.service.impl;

import com.zy.constant.SysMenuConstant;
import com.zy.dao.po.SysMenu;
import com.zy.dto.out.sys.SysMenuDto;
import com.zy.service.BaseService;
import com.zy.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SysMenuService extends BaseService implements ISysMenuService {


    @Override
    public List<SysMenuDto> getMenu(String userName) {
        List<SysMenu> sysMenus = daoService.selectList(new SysMenu());
        List<SysMenuDto> list = new ArrayList<SysMenuDto>();
        Iterator<SysMenu> iterator = sysMenus.iterator();
        while (iterator.hasNext()){
            createMenu(list, iterator, iterator.next());
        }
        return list;
    }

    public void createMenu(List<SysMenuDto> list, Iterator<SysMenu>  menus, SysMenu sysMenus) {
        SysMenuDto dto = new SysMenuDto();
        if (SysMenuConstant.IS_PARENT_TRUE == sysMenus.getIsParent()) {
            dto.setTitle(sysMenus.getMenuName());
            dto.setIndex(sysMenus.getMenuUrl());
            dto.setIcon(sysMenus.getMenuIcon());
            List<SysMenuDto> subs = new ArrayList<SysMenuDto>();
            while (menus.hasNext()){
                SysMenu sys = menus.next();
                if (sys.getParen() == sysMenus.getId()) {
                    if (sys.getId() != sysMenus.getId()) {
                        createMenu(subs, menus, sys);
                        if(SysMenuConstant.IS_PARENT_FALSE == sys.getIsParent()){
                            menus.remove();
                        }
                    }
                }
            }
            dto.setSubs(subs);
            list.add(dto);
        } else {
                dto.setTitle(sysMenus.getMenuName());
                dto.setIndex(sysMenus.getMenuUrl());
                dto.setIcon(sysMenus.getMenuIcon());
                list.add(dto);

        }
    }
}
