
package com.zy.dao.po;

import com.zy.dao.common.BasePo;

public class SysRole extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "SysRole";
	public static final String ALIAS_ID = "角色id";
	public static final String ALIAS_ROLE_NAME = "roleName";
	public static final String ALIAS_TYPE = "角色的类型，1：管理员角色，2：其他";
	public static final String ALIAS_STATUS = "状态，1：可用，0：冻结";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_OPERATOR = "操作者";
	public static final String ALIAS_OPERATE_TIME = "最后一次更新的时间";
	public static final String ALIAS_OPERATE_IP = "最后一次更新者的ip地址";
	

	//columns START
    /**
     * roleName       db_column: role_name 
     */ 	
	private String roleName;
    /**
     * 角色的类型，1：管理员角色，2：其他       db_column: type 
     */ 	
	private Integer type;
    /**
     * 状态，1：可用，0：冻结       db_column: status 
     */ 	
	private Integer status;
    /**
     * 备注       db_column: remark 
     */ 	
	private String remark;
    /**
     * 操作者       db_column: operator 
     */ 	
	private String operator;
    /**
     * 最后一次更新的时间       db_column: operate_time 
     */ 	
	private java.util.Date operateTime;
    /**
     * 最后一次更新者的ip地址       db_column: operate_ip 
     */ 	
	private String operateIp;
	//columns END


	
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(String value) {
		this.roleName = value;
	}
	
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String value) {
		this.remark = value;
	}
	
	
	public String getOperator() {
		return this.operator;
	}
	
	public void setOperator(String value) {
		this.operator = value;
	}
	
	
	public java.util.Date getOperateTime() {
		return this.operateTime;
	}
	
	public void setOperateTime(java.util.Date value) {
		this.operateTime = value;
	}
	
	
	public String getOperateIp() {
		return this.operateIp;
	}
	
	public void setOperateIp(String value) {
		this.operateIp = value;
	}
	

	

}

