package com.goku.coreui.sys.controller.sysrole;

import com.goku.coreui.sys.config.log.LoggerInfo;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysRole;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2018/1/23.
 */
public interface RoleRestController {
    @LoggerInfo(Method = "/api/sys/role/save",Name = "权限新增")
    String  save( SysRole sysRole);
    @LoggerInfo(Method = "/api/sys/role/delete",Name = "权限删除")
    String  delete(String roleId);
    @LoggerInfo(Method = "/api/sys/role/menuauth",Name = "权限菜单赋值")
    String  menuauth(@RequestBody Map<String, Object> sys);
}
