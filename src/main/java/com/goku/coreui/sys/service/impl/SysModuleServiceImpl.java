package com.goku.coreui.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.mapper.ext.SysModuleExtMapper;
import com.goku.coreui.sys.model.SysModule;
import com.goku.coreui.sys.model.SysUser;
import com.goku.coreui.sys.service.SysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
}
