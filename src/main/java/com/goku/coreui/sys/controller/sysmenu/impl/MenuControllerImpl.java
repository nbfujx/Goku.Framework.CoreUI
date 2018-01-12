package com.goku.coreui.sys.controller.sysmenu.impl;

import com.goku.coreui.sys.controller.sysmenu.MenuController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.service.impl.SysMenuServiceImpl;
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
@RequestMapping("/sys/menu")
public class MenuControllerImpl implements MenuController {

    @Autowired
    SysMenuServiceImpl sysMenuService;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:menu:query"})
    public String  list(Model model) {
        return  "sys/menu/list";
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:menu:add"})
    public String  add(@PathParam("moduleId") String moduleId, Model model) {
        model.addAttribute("pageTitle","菜单新增");
        model.addAttribute("sysMenu",null);
        return  "sys/menu/edit";
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:menu:edit"})
    public String  edit(@PathParam("menuId") String menuId, Model model) {
        SysMenu sysMenu=sysMenuService.getMenuByMenuId(menuId);
        model.addAttribute("pageTitle","菜单修改");
        model.addAttribute("sysMenu",sysMenu);
        return  "sys/menu/edit";
    }
}
