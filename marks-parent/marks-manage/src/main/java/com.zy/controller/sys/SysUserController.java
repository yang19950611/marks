package com.zy.controller.sys;

import com.zy.controller.BaseController;
import com.zy.resp.CodeMsg;
import com.zy.resp.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SysUserController extends BaseController{


    /**
     * 登录
     */
    @RequestMapping("/login")
    public Result getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("user_name");
        logger.info(userName+" 后台管理系统登录开始");
        String passWord = request.getParameter("pass_word");
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord );
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        }catch (IncorrectCredentialsException ice){
            logger.info("对用户【" + userName +"】进行登录验证，验证未通过，错误的凭证！");
            return Result.error(new CodeMsg(1,"账号或密码错误"));
        }catch(UnknownAccountException uae){
            logger.info("对用户【" + userName +"】进行登录验证，验证未通过，未知账户！");
            return Result.error(new CodeMsg(1,"未知账户"));
        }catch(LockedAccountException lae){
            logger.info("对用户【" + userName +"】进行登录验证，验证未通过，账户锁定！");
            return Result.error(new CodeMsg(1,"账户锁定"));
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户【" + userName +"】进行登录验证，验证未通过，错误次数太多！");
            return Result.error(new CodeMsg(1,"错误次数太多"));
        }catch(AuthenticationException ae){
            logger.info("对用户【" + userName +"】进行登录验证，验证未通过，堆栈轨迹如下：！");
            return Result.error(new CodeMsg(1,"系统繁忙"));
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("token", currentUser.getSession().getId());
        System.out.println(currentUser.getSession().getId());
        return Result.success(map);
    }


}
