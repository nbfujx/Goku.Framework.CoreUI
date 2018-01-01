package com.goku.coreui.sys.mapper.ext;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/30.
 */
public interface SysMenuExtMapper {
    List<HashMap<String,String>> getModuleMenus(String ModuleId,String UserId);
}
