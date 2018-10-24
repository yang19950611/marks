package com.zy.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
    public final Logger logger = LoggerFactory.getLogger(ShiroFormAuthenticationFilter.class);
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        //如果用户名为空，则说明session失效，返回错误码10006
        if (subject.getPrincipal() == null) {
            Map<Object, Object> map = new HashMap<>();
            map.put("code", 10006);
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.append(JSON.toJSONString(map));
            } catch (IOException e) {
                logger.error("返回异常：",e);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return false;
        } else {
            return true;
        }
    }
}