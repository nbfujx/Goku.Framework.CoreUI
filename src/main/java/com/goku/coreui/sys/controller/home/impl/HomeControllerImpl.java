package com.goku.coreui.sys.controller.home.impl;

import com.goku.coreui.sys.controller.home.HomeController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysModule;
import com.goku.coreui.sys.service.SysMenuService;
import com.goku.coreui.sys.service.impl.SysModuleServiceImpl;
import com.goku.coreui.sys.util.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
public class HomeControllerImpl implements HomeController {

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    MenuTreeUtil menuTreeUtil;

    @Autowired
    SysModuleServiceImpl sysModuleService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String defaultviews() {
        return "login";
    }

    @RequestMapping("/home")
    public String home(Model model,@RequestParam(value="moduleId", required=false, defaultValue="") String moduleId) {
        List<SysModule>  sysModules=sysModuleService.getUserModules("999");
        List<SysMenu>   sysMens= menuTreeUtil.menuList(sysMenuService.getModuleMenus("28c3ef4eefb111e7a2360a0027000038","999"));
        //List<SysNotice>  sysNotices=new ArrayList<SysNotice>();
        //List<SysSchedule>  sysSchedules=new ArrayList<SysSchedule>();
        model.addAttribute("sysModules",sysModules);
        model.addAttribute("sysMens",sysMens);
        model.addAttribute("moduleName","系统模块");
        //model.addAttribute("sysNotices",sysNotices);
        //model.addAttribute("sysSchedules",sysSchedules);
        model.addAttribute("indexPage","sys/index");
        return "homepage";
    }


}
