package com.goku.coreui.sys.service;

import com.goku.coreui.sys.model.SysRole;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/23.
 */
public interface SysRoleService {
    SysRole selectByPrimaryKey(String RoleId);
    List<SysRole> getRoleForPaging();
    int deleteRole(String RoleId);
    int saveRole(SysRole sysRole);
}
