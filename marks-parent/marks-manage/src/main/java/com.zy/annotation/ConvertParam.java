package com.zy.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
/**
 *  yanghy
 *  //用于请求参数转换
 *  19:14 2018/9/12
 */
public @interface ConvertParam {
    public String value() default "";
}
