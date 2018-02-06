package com.goku.coreui.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.mapper.ext.SysUserAuthExtMapper;
import com.goku.coreui.sys.mapper.ext.SysUserExtMapper;
import com.goku.coreui.sys.mapper.ext.SysUserRoleExtMapper;
import com.goku.coreui.sys.model.*;
import com.goku.coreui.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by nbfujx on 2018/1/9.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserExtMapper sysuserextmapper;

    @Autowired
    SysUserAuthExtMapper sysUserAuthExtMapper;

    @Autowired
    SysUserRoleExtMapper sysUserRoleExtMapper;

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

    @Override
    public int menuAuth(List<SysMenu> sysMenus, String userid, String moduleId) {
        int deleteResult=0;
        int addResult=0;
        deleteResult=sysUserAuthExtMapper.deleteUserAuthByModuleId(userid,moduleId);
        if(sysMenus!=null) {
            SysUserAuth sua = null;
            for (SysMenu sr : sysMenus) {
                sua = new SysUserAuth();
                sua.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                sua.setUserId(userid);
                sua.setMenuId(sr.getId());
                addResult = sysUserAuthExtMapper.insert(sua);
            }
        }else
        {
            addResult = 1;
        }
        if (addResult == 1 && deleteResult >= 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int roleauth(List<SysRole> sysRoles, String userid) {
        int deleteResult=0;
        int addResult=0;
        deleteResult=sysUserRoleExtMapper.deleteUserRole(userid);
        if(sysRoles!=null) {
            SysUserRole sur = null;
            for (SysRole sr : sysRoles) {
                sur = new SysUserRole();
                sur.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                sur.setUserId(userid);
                sur.setRoleId(sr.getId());
                addResult = sysUserRoleExtMapper.insert(sur);
            }
        }else
        {
            addResult = 1;
        }
        if (addResult == 1 && deleteResult >= 0) {
            return 1;
        }
        return 0;
    }
}
