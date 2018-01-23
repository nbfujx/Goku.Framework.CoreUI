package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysRoleMapper;
import com.goku.coreui.sys.model.SysRole;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/23.
 */
public interface SysRoleExtMapper extends SysRoleMapper {
    List<SysRole> getRoleForPaging();
}
