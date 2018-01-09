package com.goku.coreui.sys.controller.sysuser.impl;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
@RequestMapping("/sys/user")
public class UserControllerImpl {

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:user:query"})
    public String  list(Model model) {
        return  "sys/user/list";
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:user:add"})
    public String  add(Model model) {
        return  "sys/user/edit";
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:user:edit"})
    public String  edit(Model model) {
        return  "sys/user/edit";
    }


}
