package com.goku.coreui.sys.controller.sysmodule.impl;

import com.goku.coreui.sys.controller.sysmodule.ModuleController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysModule;
import com.goku.coreui.sys.service.SysModuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

/**
 * Created by nbfujx on 2018/1/10.
 */
@Controller
@RequestMapping("/sys/module")
public class ModuleControllerImpl implements ModuleController {

    @Autowired
    SysModuleService sysModuleService;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:module:query"})
    public String  list(Model model) {
        return  "sys/module/list";
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:module:add"})
    public String  add(Model model) {
        model.addAttribute("pageTitle","模块新增");
        SysModule sysModule=new SysModule();
        model.addAttribute("sysModule",sysModule);
        return  "sys/module/edit";
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:module:edit"})
    public String  edit(@PathParam("menuId") String moduleId, Model model) {
        model.addAttribute("pageTitle","模块修改");
        SysModule sysModule=sysModuleService.selectByPrimaryKey(moduleId);
        model.addAttribute("sysModule",sysModule);
        return  "sys/module/edit";
    }
}
