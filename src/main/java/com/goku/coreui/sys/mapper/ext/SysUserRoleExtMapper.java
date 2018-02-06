package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysUserRoleMapper;
import com.goku.coreui.sys.model.SysRole;

import java.util.List;

/**
 * Created by nbfujx on 2018/2/6.
 */
public interface SysUserRoleExtMapper  extends SysUserRoleMapper {
    int deleteUserRole(String userid);
}
