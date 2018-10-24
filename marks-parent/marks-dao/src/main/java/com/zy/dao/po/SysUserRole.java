
package com.zy.dao.po;

import com.zy.dao.common.BasePo;

public class SysUserRole extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "SysUserRole";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_ROLE_ID = "roleId";
	

	//columns START
    /**
     * userId       db_column: user_id 
     */ 	
	private Integer userId;
    /**
     * roleId       db_column: role_id 
     */ 	
	private Integer roleId;
	//columns END


	
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	
	public Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(Integer value) {
		this.roleId = value;
	}
	

	

}

