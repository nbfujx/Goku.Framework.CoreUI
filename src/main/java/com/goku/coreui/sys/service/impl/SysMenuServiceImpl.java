package com.goku.coreui.sys.service.impl;

import com.goku.coreui.sys.mapper.ext.SysMenuExtMapper;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<SysMenu> getMenuForPaging(String ModuleId) {
        return sysMenuExtMapper.getMenuForPaging(ModuleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteMenu(String MenuId) {
        //需要修改
        int deleteResult=0;
        int updateResult=0;
        SysMenu sysMenu = sysMenuExtMapper.selectByPrimaryKey(MenuId);
        String parentId=sysMenu.getParentId();
        deleteResult=sysMenuExtMapper.deleteByPrimaryKey(MenuId);
        int count=sysMenuExtMapper.getCountByParentId(parentId);
        if(count==0){
            updateResult = sysMenuExtMapper.updateMenuIsParent(parentId);
        }else{
            updateResult=1;
        }
        if (deleteResult == 1 && updateResult == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveMenu(SysMenu sysMenu) {
        int addResult=0;
        int updateResult=0;
        if("".equals(sysMenu.getId())) {
            SysMenu newMenu = new SysMenu();
            newMenu.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            newMenu.setModuleId(sysMenu.getModuleId());
            newMenu.setName(sysMenu.getName());
            if("".equals(sysMenu.getParentId())){
                newMenu.setParentId("-1");
            }else{
                newMenu.setParentId(sysMenu.getParentId());
            }
            newMenu.setIsparent("0");
            newMenu.setSort(sysMenu.getSort());
            newMenu.setIcon(sysMenu.getIcon());
            newMenu.setDescription(sysMenu.getDescription());
            newMenu.setIfShow(sysMenu.getIfShow());
            newMenu.setIsLeaf("1");
            newMenu.setPermission(sysMenu.getPermission());
            newMenu.setUrl(sysMenu.getUrl());
            addResult=sysMenuExtMapper.insert(newMenu);
            if(!"-1".equals(newMenu.getParentId())) {
                updateResult = sysMenuExtMapper.updateMenuIsLeaf(newMenu.getParentId());
            }else{
                updateResult = 1;
            }
        }else{
            SysMenu newMenu = sysMenuExtMapper.selectByPrimaryKey(sysMenu.getId());
            newMenu.setModuleId(sysMenu.getModuleId());
            newMenu.setName(sysMenu.getName());
            if("".equals(sysMenu.getParentId())){
                newMenu.setParentId("-1");
            }else{
                newMenu.setParentId(sysMenu.getParentId());
            }
            newMenu.setSort(sysMenu.getSort());
            newMenu.setIcon(sysMenu.getIcon());
            newMenu.setDescription(sysMenu.getDescription());
            newMenu.setIfShow(sysMenu.getIfShow());
            newMenu.setPermission(sysMenu.getPermission());
            newMenu.setUrl(sysMenu.getUrl());
            addResult=sysMenuExtMapper.updateByPrimaryKey(newMenu);
            if(!"-1".equals(newMenu.getParentId())) {
                updateResult = sysMenuExtMapper.updateMenuIsLeaf(newMenu.getParentId());
            }else{
                updateResult = 1;
            }
        }
        if (addResult == 1 && updateResult == 1) {
            return 1;
        }
        return 0;
    }
}
