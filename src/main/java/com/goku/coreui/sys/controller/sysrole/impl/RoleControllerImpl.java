package com.goku.coreui.sys.controller.sysrole.impl;

import com.goku.coreui.sys.controller.sysrole.RoleController;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.service.SysRoleService;
import com.goku.coreui.sys.util.TreeSelectUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nbfujx on 2018/1/23.
 */
@Controller
@RequestMapping("/sys/role")
public class RoleControllerImpl implements RoleController {

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    TreeSelectUtil treeSelectUtil;

    @Override
    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:role:query"})
    public String list(Model model) {
        return  "sys/role/list";
    }

    @Override
    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:role:add"})
    public String add(Model model) {
        model.addAttribute("pageTitle","权限新增");
        SysRole sysRole=new SysRole();
        model.addAttribute("sysRole",sysRole);
        return  "sys/role/edit";
    }

    @Override
    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:role:edit"})
    public String edit(String roleId, Model model) {
        model.addAttribute("pageTitle","权限修改");
        SysRole sysRole=sysRoleService.selectByPrimaryKey(roleId);
        model.addAttribute("sysRole",sysRole);
        return  "sys/role/edit";
    }
}
