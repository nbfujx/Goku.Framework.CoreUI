package com.goku.coreui.sys.controller.sysrole;

import com.goku.coreui.sys.config.log.LoggerInfo;
import com.goku.coreui.sys.model.SysRole;

/**
 * Created by nbfujx on 2018/1/23.
 */
public interface RoleRestController {
    @LoggerInfo(Method = "/api/sys/role/save",Name = "权限新增")
    String  save( SysRole sysRole);
    @LoggerInfo(Method = "/api/sys/role/delete",Name = "权限删除")
    String  delete(String roleId);
}
