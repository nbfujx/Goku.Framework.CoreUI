package com.goku.coreui.sys.controller.sysrole.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.goku.coreui.sys.controller.sysrole.RoleRestController;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.service.SysRoleService;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import com.goku.coreui.sys.util.TreeSelectUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/23.
 */
@RestController
@RequestMapping("/api/sys/role")
public class RoleRestControllerImpl implements RoleRestController {

    @Autowired
    BreadcrumbUtil breadcrumbUtil;

    @Autowired
    TreeSelectUtil treeSelectUtil;

    @Autowired
    SysRoleService sysRoleService;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:role:query"})
    public String  list() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/role/getListPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:role:add"})
    public String  add() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/role/addPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:role:edit"})
    public String  edit() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/role/editPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/getRoleForPaging")
    @RequiresPermissions(value={"sys:role:query"})
    public String  getRoleForPaging()
    {
        List<SysRole> sysroles=sysRoleService.getRoleForPaging();
        return JSON.toJSONString (sysroles, SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/getRoleForTree")
    @RequiresPermissions(value={"sys:role:query"})
    public String  getRoleForTree()
    {
        return JSON.toJSONString (treeSelectUtil.RoleSelectTree(sysRoleService.getRoleForPaging()));
    }


    @Override
    @RequestMapping("/save")
    @RequiresPermissions(value={"sys:role:add","sys:role:edit"},logical = Logical.OR)
    public String save(@RequestBody SysRole sysRole) {
        int result=sysRoleService.saveRole(sysRole);
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
    }

    @Override
    @RequestMapping("/delete")
    @RequiresPermissions(value={"sys:role:delete"})
    public String delete(@RequestBody String roleId) {
        roleId=roleId.replaceAll("\"","");
        int result=sysRoleService.deleteRole(roleId);
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
    }
}
