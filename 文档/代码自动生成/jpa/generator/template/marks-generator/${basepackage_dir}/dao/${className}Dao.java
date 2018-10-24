<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage};

import com.zy.jpa.po.${className};
import org.springframework.data.jpa.repository.JpaRepository;

public interface ${className}Dao extends JpaRepository<${className},Integer>{


}
