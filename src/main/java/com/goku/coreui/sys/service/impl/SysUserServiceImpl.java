package com.goku.coreui.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.mapper.ext.SysUserExtMapper;
import com.goku.coreui.sys.model.SysUser;
import com.goku.coreui.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/9.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserExtMapper sysuserextmapper;

    @Override
    public PageInfo getUserForPaging(String username, String name, String orderFiled, String orderSort, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<SysUser> list = sysuserextmapper.getUserForPaging(username, name,orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public SysUser selectByPrimaryKey(String UserId) {
        return sysuserextmapper.selectByPrimaryKey(UserId);
    }

    @Override
    public int deleteUser(String UserId) {
        return 0;
    }

    @Override
    public int saveUser(SysUser sysUser) {
        return 0;
    }
}
