package com.goku.coreui.sys.service;

import com.goku.coreui.sys.model.SysMenu;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/1.
 */
public interface SysMenuService {
    List<SysMenu> getModuleMenus(String ModuleId, String UserId);
}
