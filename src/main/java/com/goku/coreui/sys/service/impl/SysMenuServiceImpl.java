package com.goku.coreui.sys.service.impl;

import com.goku.coreui.sys.mapper.ext.SysMenuExtMapper;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/1.
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuExtMapper sysMenuExtMapper;

    @Override
    public List<SysMenu> getModuleMenus(String ModuleId, String UserId) {
        return sysMenuExtMapper.getModuleMenus(ModuleId,UserId);
    }

    @Override
    public SysMenu getMenuByMenuId(String MenuId) {
        return sysMenuExtMapper.selectByPrimaryKey(MenuId);
    }

    @Override
    public SysMenu getMenuByUrl(String Url) {
        return sysMenuExtMapper.getMenuByUrl(Url);
    }
}
