
package com.zy.jpa.po;
import javax.persistence.*;

@Entity
@Table(name = "sys_menu")
public class SysMenu extends BasePo{

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
     * id       db_column: id 
     */
	
	private Integer id;
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


	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id", nullable=false, length=10)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	

	@Column(name="menu_name", nullable=false, length=100)
	public String getMenuName() {
		return this.menuName;
	}
	
	public void setMenuName(String value) {
		this.menuName = value;
	}
	

	@Column(name="menu_url", nullable=false, length=200)
	public String getMenuUrl() {
		return this.menuUrl;
	}
	
	public void setMenuUrl(String value) {
		this.menuUrl = value;
	}
	

	@Column(name="menu_icon", nullable=false, length=100)
	public String getMenuIcon() {
		return this.menuIcon;
	}
	
	public void setMenuIcon(String value) {
		this.menuIcon = value;
	}
	

	@Column(name="is_parent", nullable=false, length=10)
	public Integer getIsParent() {
		return this.isParent;
	}
	
	public void setIsParent(Integer value) {
		this.isParent = value;
	}
	

	@Column(name="order_num", nullable=false, length=10)
	public Integer getOrderNum() {
		return this.orderNum;
	}
	
	public void setOrderNum(Integer value) {
		this.orderNum = value;
	}
	

	@Column(name="paren", nullable=true, length=10)
	public Integer getParen() {
		return this.paren;
	}
	
	public void setParen(Integer value) {
		this.paren = value;
	}
	

	@Column(name="create_time", nullable=true, length=19)
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	

	@Column(name="modify_time", nullable=true, length=19)
	public java.util.Date getModifyTime() {
		return this.modifyTime;
	}
	
	public void setModifyTime(java.util.Date value) {
		this.modifyTime = value;
	}
	


	

}

