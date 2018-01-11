package com.goku.coreui.sys.controller.sysmodule.impl;

import com.goku.coreui.sys.controller.sysmodule.ModuleController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nbfujx on 2018/1/10.
 */
@Controller
@RequestMapping("/sys/module")
public class ModuleControllerImpl implements ModuleController {

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:module:query"})
    public String  list(Model model) {
        return  "sys/module/list";
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:module:add"})
    public String  add(Model model) {
        return  "sys/module/edit";
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:module:edit"})
    public String  edit(Model model) {
        return  "sys/module/edit";
    }
}
