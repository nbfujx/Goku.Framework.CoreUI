package com.goku.coreui.sys.controller.index.impl;

import com.goku.coreui.sys.controller.index.IndexController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
@RequestMapping("/sys")
public class IndexControllerImpl implements IndexController {

    @RequestMapping("/index")
    @RequiresPermissions(value={"sys:index:*"})
    public String  index(Model model) {
        model.addAttribute("str","表格");
        return  "sys/index";
    }



}
