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
    List<SysMenu> selectByUserId(String id);
}
