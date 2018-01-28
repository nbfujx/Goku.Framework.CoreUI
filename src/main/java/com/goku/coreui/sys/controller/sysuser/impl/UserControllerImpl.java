package com.goku.coreui.sys.controller.sysuser.impl;

import com.goku.coreui.sys.controller.sysuser.UserController;
import com.goku.coreui.sys.model.SysUser;
import com.goku.coreui.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
@RequestMapping("/sys/user")
public class UserControllerImpl implements UserController {

    @Autowired
    SysUserService sysUserService;

    @Override
    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:user:query"})
    public String  list(Model model) {
        return  "sys/user/list";
    }

    @Override
    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:user:add"})
    public String  add(Model model) {
        model.addAttribute("pageTitle","用户新增");
        SysUser sysUser=new SysUser();
        model.addAttribute("sysUser",sysUser);
        return  "sys/user/edit";
    }

    @Override
    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:user:edit"})
    public String  edit(@PathParam("userId") String UserId, Model model) {
        model.addAttribute("pageTitle","用户修改");
        SysUser sysUser=sysUserService.selectByPrimaryKey(UserId);
        model.addAttribute("sysUser",sysUser);
        return  "sys/user/edit";
    }


}
