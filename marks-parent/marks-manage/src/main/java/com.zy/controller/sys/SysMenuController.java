package com.zy.controller.sys;

import com.zy.controller.BaseController;
import com.zy.dto.out.sys.SysMenuDto;
import com.zy.resp.Result;
import com.zy.service.impl.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController  extends BaseController{

    @Autowired
    SysMenuService sysMenuService;
    /**
     * 获取后台管理系统菜单
     */
    @RequestMapping("/getMenu")
    public Result getMenu(HttpServletRequest request, HttpServletResponse response) {
        Subject currentUser = SecurityUtils.getSubject();
        String userName = (String)currentUser.getPrincipal();
        List<SysMenuDto> menus = sysMenuService.getMenu(userName);

        return Result.success(menus);
    }
}
