package com.zy.controller;

import com.zy.annotation.ConvertParam;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseController {
    public final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     *  yanghy
     *  // 将request中的请求参数映射到实体中
     *  18:21 2018/9/13
     *  参数 [request, clazz ]
     *  返回值  T
     */
    public <T> T getPara(HttpServletRequest request, Class<T> clazz){
        T o = null;
        try {
            o = clazz.newInstance();
            List<Field> fields = new ArrayList() ;
            Class tempClass = clazz;
            while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
                fields.addAll(Arrays.asList(tempClass .getDeclaredFields()));
                tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
            }
            for (Field field:fields) {

                field.setAccessible(true);
                String name = field.getName();
                Class type = field.getType();
                String parameter;
                if(field.isAnnotationPresent(ConvertParam.class)){
                    parameter = request.getParameter(field.getAnnotation(ConvertParam.class).value());
                }else{
                    parameter = request.getParameter(name);

                }
                if(StringUtils.isNotBlank(parameter)){
                    if(type.getName().equals("java.lang.Integer")){
                        field.set(o,Integer.valueOf(parameter));
                    }else{
                        field.set(o,parameter);
                    }

                }
            }
        }catch (Exception e) {
            logger.error("解析参数异常",e);
        }
        return o;
    }
}
