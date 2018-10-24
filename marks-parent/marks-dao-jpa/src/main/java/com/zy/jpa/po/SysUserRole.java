
package com.zy.jpa.po;
import javax.persistence.*;

@Entity
@Table(name = "sys_user_role")
public class SysUserRole extends BasePo{

	//alias
	public static final String TABLE_ALIAS = "SysUserRole";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_ROLE_ID = "roleId";
	

	//columns START
    /**
     * id       db_column: id 
     */
	
	private Integer id;
    /**
     * userId       db_column: user_id 
     */
	
	private Integer userId;
    /**
     * roleId       db_column: role_id 
     */
	
	private Integer roleId;
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
	

	@Column(name="user_id", nullable=true, length=10)
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
	

	@Column(name="role_id", nullable=true, length=10)
	public Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(Integer value) {
		this.roleId = value;
	}
	


	

}

