
package com.zy.jpa.po;
import javax.persistence.*;

@Entity
@Table(name = "sys_permission")
public class SysPermission extends BasePo{

	//alias
	public static final String TABLE_ALIAS = "SysPermission";
	public static final String ALIAS_ID = "权限id";
	public static final String ALIAS_CODE = "权限码";
	public static final String ALIAS_PERM_NAME = "权限名称";
	public static final String ALIAS_STATUS = "状态，1：正常，0：冻结";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_OPERATOR = "操作者";
	public static final String ALIAS_OPERATE_TIME = "最后一次更新时间";
	public static final String ALIAS_OPERATE_IP = "最后一个更新者的ip地址";
	

	//columns START
    /**
     * 权限id       db_column: id 
     */
	
	private Integer id;
    /**
     * 权限码       db_column: code 
     */
	
	private String code;
    /**
     * 权限名称       db_column: perm_name 
     */
	
	private String permName;
    /**
     * 状态，1：正常，0：冻结       db_column: status 
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
     * 最后一次更新时间       db_column: operate_time 
     */
	
	private java.util.Date operateTime;
    /**
     * 最后一个更新者的ip地址       db_column: operate_ip 
     */
	
	private String operateIp;
	//columns END


	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id", nullable=false, length=10)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	

	@Column(name="code", nullable=false, length=20)
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String value) {
		this.code = value;
	}
	

	@Column(name="perm_name", nullable=false, length=20)
	public String getPermName() {
		return this.permName;
	}
	
	public void setPermName(String value) {
		this.permName = value;
	}
	

	@Column(name="status", nullable=false, length=10)
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	

	@Column(name="remark", nullable=true, length=200)
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String value) {
		this.remark = value;
	}
	

	@Column(name="operator", nullable=false, length=20)
	public String getOperator() {
		return this.operator;
	}
	
	public void setOperator(String value) {
		this.operator = value;
	}
	

	@Column(name="operate_time", nullable=false, length=19)
	public java.util.Date getOperateTime() {
		return this.operateTime;
	}
	
	public void setOperateTime(java.util.Date value) {
		this.operateTime = value;
	}
	

	@Column(name="operate_ip", nullable=false, length=20)
	public String getOperateIp() {
		return this.operateIp;
	}
	
	public void setOperateIp(String value) {
		this.operateIp = value;
	}
	


	

}

