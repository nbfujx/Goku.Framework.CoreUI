package com.goku.coreui.sys.controller.sysmenu.impl;

import com.goku.coreui.sys.controller.sysmenu.MenuController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nbfujx on 2018/1/10.
 */
@Controller
@RequestMapping("/sys/menu")
public class MenuControllerImpl implements MenuController {

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:menu:query"})
    public String  list(Model model) {
        return  "sys/menu/list";
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:menu:add"})
    public String  add(Model model) {
        return  "sys/menu/edit";
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:menu:edit"})
    public String  edit(Model model) {
        return  "sys/menu/edit";
    }
}
