
package com.zy.dao.po;

import com.zy.dao.common.BasePo;

public class SysRolePerm extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "SysRolePerm";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_ROLE_ID = "roleId";
	public static final String ALIAS_PERM_ID = "permId";
	

	//columns START
    /**
     * roleId       db_column: role_id 
     */ 	
	private Integer roleId;
    /**
     * permId       db_column: perm_id 
     */ 	
	private Integer permId;
	//columns END


	
	
	public Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(Integer value) {
		this.roleId = value;
	}
	
	
	public Integer getPermId() {
		return this.permId;
	}
	
	public void setPermId(Integer value) {
		this.permId = value;
	}
	

	

}

