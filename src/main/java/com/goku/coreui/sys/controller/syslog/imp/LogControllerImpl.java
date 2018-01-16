package com.goku.coreui.sys.controller.syslog.imp;

import com.goku.coreui.sys.controller.syslog.LogController;
import com.goku.coreui.sys.model.SysMenu;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

/**
 * Created by nbfujx on 2018/1/16.
 */
@Controller
@RequestMapping("/sys/log")
public class LogControllerImpl implements LogController {

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:log:query"})
    public String  list(Model model) {
        return  "sys/log/list";
    }

}
