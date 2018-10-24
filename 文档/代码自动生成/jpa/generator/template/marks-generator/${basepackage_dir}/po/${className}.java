<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage};
import javax.persistence.*;

@Entity
@Table(name = "${table.sqlName}")
public class ${className} extends BasePo{

	//alias
	public static final String TABLE_ALIAS = "${table.tableAlias}";
	<#list table.columns as column>
	public static final String ALIAS_${column.constantName} = "${column.columnAlias}";
	</#list>
	
	<@generateFields/>
	<@generateCompositeIdConstructorIfis/>
	<@generateNotPkProperties/>
	<@generateJavaOneToMany/>
	<@generateJavaManyToOne/>

	

}

<#macro generateFields>

<#if table.compositeId>
	<#list table.columns as column>
		
	private ${column.javaType} ${column.columnNameLower};
		
	</#list>
<#else>
	//columns START
	<#list table.columns as column>
    /**
     * ${column.columnAlias!}       db_column: ${column.sqlName} 
     */
	
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	//columns END
</#if>

</#macro>

<#macro generateCompositeIdConstructorIfis>

	<#if table.compositeId>
	
	public ${className}PO(){
	}
	public ${className}PO(${className}Id id) {
		this.id = id;
	}
	</#if>
	
</#macro>

<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if column.pk>
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	</#if>
	@Column(name="${column.sqlName}", nullable=${column.nullable?c}, length=${column.size})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	

	</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	

	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>

