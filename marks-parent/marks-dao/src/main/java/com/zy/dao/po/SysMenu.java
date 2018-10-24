
package com.zy.dao.po;

import com.zy.dao.common.BasePo;

public class SysMenu extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "SysMenu";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_MENU_NAME = "菜单名称";
	public static final String ALIAS_MENU_URL = "菜单地址";
	public static final String ALIAS_MENU_ICON = "菜单图标";
	public static final String ALIAS_IS_PARENT = "是否有父级";
	public static final String ALIAS_ORDER_NUM = "序号";
	public static final String ALIAS_PAREN = "父级菜单ID";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_MODIFY_TIME = "modifyTime";
	

	//columns START
    /**
     * 菜单名称       db_column: menu_name 
     */ 	
	private String menuName;
    /**
     * 菜单地址       db_column: menu_url 
     */ 	
	private String menuUrl;
    /**
     * 菜单图标       db_column: menu_icon 
     */ 	
	private String menuIcon;
    /**
     * 是否有父级       db_column: is_parent 
     */ 	
	private Integer isParent;
    /**
     * 序号       db_column: order_num 
     */ 	
	private Integer orderNum;
    /**
     * 父级菜单ID       db_column: paren 
     */ 	
	private Integer paren;
    /**
     * createTime       db_column: create_time 
     */ 	
	private java.util.Date createTime;
    /**
     * modifyTime       db_column: modify_time 
     */ 	
	private java.util.Date modifyTime;
	//columns END


	
	
	public String getMenuName() {
		return this.menuName;
	}
	
	public void setMenuName(String value) {
		this.menuName = value;
	}
	
	
	public String getMenuUrl() {
		return this.menuUrl;
	}
	
	public void setMenuUrl(String value) {
		this.menuUrl = value;
	}
	
	
	public String getMenuIcon() {
		return this.menuIcon;
	}
	
	public void setMenuIcon(String value) {
		this.menuIcon = value;
	}
	
	
	public Integer getIsParent() {
		return this.isParent;
	}
	
	public void setIsParent(Integer value) {
		this.isParent = value;
	}
	
	
	public Integer getOrderNum() {
		return this.orderNum;
	}
	
	public void setOrderNum(Integer value) {
		this.orderNum = value;
	}
	
	
	public Integer getParen() {
		return this.paren;
	}
	
	public void setParen(Integer value) {
		this.paren = value;
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
	

	

}

