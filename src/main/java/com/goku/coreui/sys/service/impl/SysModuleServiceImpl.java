package com.goku.coreui.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.mapper.ext.SysModuleExtMapper;
import com.goku.coreui.sys.model.SysModule;
import com.goku.coreui.sys.service.SysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by nbfujx on 2018/1/1.
 */
@Service
public class SysModuleServiceImpl implements SysModuleService {

    @Autowired
    SysModuleExtMapper sysModuleExtMapper;

    @Override
    public List<SysModule> getUserModules(String UserId) {
        return sysModuleExtMapper.getUserModules(UserId);
    }

    @Override
    public SysModule selectByPrimaryKey(String id) {
        return sysModuleExtMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo getModuleForPaging() {
        PageHelper.startPage(1, Integer.MAX_VALUE);
        List<SysModule> list = sysModuleExtMapper.getModuleForPaging();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public int saveModule(SysModule sysmodule) {
        int addResult=0;
        if("".equals(sysmodule.getId())) {
            SysModule newModule = new SysModule();
            newModule.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            newModule.setName(sysmodule.getName());
            newModule.setIndexPage(sysmodule.getIndexPage());
            newModule.setSort(sysmodule.getSort());
            newModule.setIfShow(sysmodule.getIfShow());
            newModule.setDescription(sysmodule.getDescription());
            addResult=sysModuleExtMapper.insert(newModule);
        }else{
            SysModule newModule =sysModuleExtMapper.selectByPrimaryKey(sysmodule.getId());
            newModule.setName(sysmodule.getName());
            newModule.setIndexPage(sysmodule.getIndexPage());
            newModule.setSort(sysmodule.getSort());
            newModule.setIfShow(sysmodule.getIfShow());
            newModule.setDescription(sysmodule.getDescription());
            addResult=sysModuleExtMapper.updateByPrimaryKey(newModule);
        }
        return addResult;
    }

    @Override
    public int deleteModuleByids(String ids) {
        return sysModuleExtMapper.deleteModuleByids(ids);
    }
}
