package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysMenuMapper;
import com.goku.coreui.sys.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/30.
 */
public interface SysMenuExtMapper extends SysMenuMapper {
    List<SysMenu> getModuleMenus(@Param("ModuleId")  String ModuleId, @Param("UserId") String UserId);
    SysMenu getMenuByUrl(@Param("Url") String Url);
    List<SysMenu> getMenuByUserId(@Param("UserId") String UserId);
    List<SysMenu> getMenuForPaging(@Param("ModuleId")  String ModuleId);
    int updateMenuIsLeaf(@Param("id")  String id);
    int updateMenuIsParent(@Param("id")  String id);
    int getCountByParentId(@Param("id")  String id);
    List<SysMenu> getUserModuleMenus(@Param("ModuleId")  String ModuleId, @Param("roleId") String roleId);
    List<SysMenu> getUserModuleMenus2(@Param("ModuleId") String moduleId, @Param("userid") String userid);
}
