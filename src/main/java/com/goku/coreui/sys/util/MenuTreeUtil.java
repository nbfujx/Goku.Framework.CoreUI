package com.goku.coreui.sys.util;

import com.goku.coreui.sys.model.SysMenu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2018/1/2.
 */
public  class MenuTreeUtil {

    public static List<SysMenu> menuList(List<SysMenu> menu){
        List<SysMenu> list = new ArrayList<>();
        for (SysMenu x : menu) {
            SysMenu sysMenu = new SysMenu();
            if("-1".equals(x.getParentId())){
                sysMenu.setId(x.getId());
                sysMenu.setModuleId(x.getModuleId());
                sysMenu.setName(x.getName());
                sysMenu.setParentId(x.getParentId());
                sysMenu.setIsparent(x.getIsparent());
                sysMenu.setSort(x.getSort());
                sysMenu.setIcon(x.getIcon());
                sysMenu.setDescription(x.getDescription());
                sysMenu.setIfShow(x.getIfShow());
                sysMenu.setIsLeaf(x.getIsLeaf());
                sysMenu.setPermission(x.getPermission());
                sysMenu.setUrl(x.getUrl());
                sysMenu.setSubMenu(menuChild(menu,x.getId()));
                list.add(sysMenu);
            }
        }
        return list;
    }

    public static List<SysMenu> menuChild(List<SysMenu> menu,String id){
        List<SysMenu> lists = new ArrayList<SysMenu>();
        for(SysMenu x:menu){
            SysMenu sysMenu = new SysMenu();
            if(id.equals(x.getParentId())){
                sysMenu.setId(x.getId());
                sysMenu.setModuleId(x.getModuleId());
                sysMenu.setName(x.getName());
                sysMenu.setParentId(x.getParentId());
                sysMenu.setIsparent(x.getIsparent());
                sysMenu.setSort(x.getSort());
                sysMenu.setIcon(x.getIcon());
                sysMenu.setDescription(x.getDescription());
                sysMenu.setIfShow(x.getIfShow());
                sysMenu.setIsLeaf(x.getIsLeaf());
                sysMenu.setPermission(x.getPermission());
                sysMenu.setUrl(x.getUrl());
                sysMenu.setSubMenu(menuChild(menu,x.getId()));
                lists.add(sysMenu);
            }
        }
        return lists;

    }
}
