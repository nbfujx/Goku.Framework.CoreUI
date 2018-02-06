package com.goku.coreui.sys.controller.sysrole;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.ui.Model;

/**
 * Created by nbfujx on 2018/1/23.
 */
public interface RoleController {

    @LoggerInfo(Method = "/sys/role/getListPage",Name = "权限列表")
    String list(Model model);
    @LoggerInfo(Method = "/sys/role/addPage",Name = "权限新增")
    String  add(Model model);
    @LoggerInfo(Method = "/sys/role/editPage",Name = "权限修改")
    String  edit(String roleId, Model model);
    @LoggerInfo(Method = "/sys/role/authPage",Name = "权限菜单赋值")
    String  auth(String roleId, Model model);
}
