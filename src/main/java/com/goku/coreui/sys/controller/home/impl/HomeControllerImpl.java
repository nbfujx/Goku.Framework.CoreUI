package com.goku.coreui.sys.controller.home.impl;

import com.goku.coreui.sys.controller.home.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
public class HomeControllerImpl implements HomeController {

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
        //List<SysModule>  sysModules=new ArrayList<SysModule>();
        //List<SysMenu>  sysMens=new ArrayList<SysMenu>();
        //List<SysNotice>  sysNotices=new ArrayList<SysNotice>();
        //List<SysSchedule>  sysSchedules=new ArrayList<SysSchedule>();
        //model.addAttribute("sysModules",sysModules);
        //model.addAttribute("sysMens",sysMens);
        //model.addAttribute("sysNotices",sysNotices);
        //model.addAttribute("sysSchedules",sysSchedules);
        model.addAttribute("indexPage","sys/index");
        return "homepage";
    }


}
