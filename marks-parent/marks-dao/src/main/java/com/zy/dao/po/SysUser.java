
package com.zy.dao.po;

import com.zy.dao.common.BasePo;

public class SysUser extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "SysUser";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_ACCOUNT = "账号";
	public static final String ALIAS_PASS_WORD = "密码";
	public static final String ALIAS_USER_NAME = "用户姓名";
	public static final String ALIAS_MOBILE = "手机号";
	public static final String ALIAS_EMAIL = "电子邮箱";
	public static final String ALIAS_STATUS = "状态 0-正常 1-停用";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_MODIFY_TIME = "modifyTime";
	public static final String ALIAS_LOGIN_TIME = "login_time";
	public static final String ALIAS_LAST_LOGIN_TIME = "上次登录时间";
	public static final String ALIAS_LOGIN_NUM = "登录次数";
	

	//columns START
    /**
     * 账号       db_column: account 
     */ 	
	private String account;
    /**
     * 密码       db_column: pass_word 
     */ 	
	private String passWord;
    /**
     * 用户姓名       db_column: user_name 
     */ 	
	private String userName;
    /**
     * 手机号       db_column: mobile 
     */ 	
	private String mobile;
    /**
     * 电子邮箱       db_column: email 
     */ 	
	private String email;
    /**
     * 状态 0-正常 1-停用       db_column: status 
     */ 	
	private Integer status;
    /**
     * createTime       db_column: create_time 
     */ 	
	private java.util.Date createTime;
    /**
     * modifyTime       db_column: modify_time 
     */ 	
	private java.util.Date modifyTime;
    /**
     * login_time       db_column: login_time 
     */ 	
	private java.util.Date loginTime;
    /**
     * 上次登录时间       db_column: last_login_time 
     */ 	
	private java.util.Date lastLoginTime;
    /**
     * 登录次数       db_column: login_num 
     */ 	
	private Integer loginNum;
	//columns END


	
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String value) {
		this.account = value;
	}
	
	
	public String getPassWord() {
		return this.passWord;
	}
	
	public void setPassWord(String value) {
		this.passWord = value;
	}
	
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String value) {
		this.userName = value;
	}
	
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String value) {
		this.mobile = value;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	
	public java.util.Date getModifyTime() {
		return this.modifyTime;
	}
	
	public void setModifyTime(java.util.Date value) {
		this.modifyTime = value;
	}
	
	
	public java.util.Date getLoginTime() {
		return this.loginTime;
	}
	
	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}
	
	
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(java.util.Date value) {
		this.lastLoginTime = value;
	}
	
	
	public Integer getLoginNum() {
		return this.loginNum;
	}
	
	public void setLoginNum(Integer value) {
		this.loginNum = value;
	}
	

	

}

