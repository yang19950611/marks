package com.zy.dao.generator;



import cn.org.rapid_framework.generator.GeneratorFacade;


public class Generator {
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        g.deleteOutRootDir();
        g.getGenerator().setTemplateRootDir("F:/generator-mybatis/template");
        g.generateByTable("sys_permission");
        g.generateByTable("sys_role");
        g.generateByTable("sys_role_perm");
        g.generateByTable("sys_user_role");
//        g.generateByTable("sys_role");
//        g.generateByTable("sys_permission");
//        g.generateByTable("sys_role_perm");
//        g.generateByTable("sys_user_role");

    }
}
