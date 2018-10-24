
package com.zy.jpa.po;
import javax.persistence.*;

@Entity
@Table(name = "sys_role_perm")
public class SysRolePerm extends BasePo{

	//alias
	public static final String TABLE_ALIAS = "SysRolePerm";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_ROLE_ID = "roleId";
	public static final String ALIAS_PERM_ID = "permId";
	

	//columns START
    /**
     * id       db_column: id 
     */
	
	private Integer id;
    /**
     * roleId       db_column: role_id 
     */
	
	private Integer roleId;
    /**
     * permId       db_column: perm_id 
     */
	
	private Integer permId;
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
	

	@Column(name="role_id", nullable=false, length=10)
	public Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(Integer value) {
		this.roleId = value;
	}
	

	@Column(name="perm_id", nullable=false, length=10)
	public Integer getPermId() {
		return this.permId;
	}
	
	public void setPermId(Integer value) {
		this.permId = value;
	}
	


	

}

