package com.goku.coreui.sys.controller.sysmodule.impl;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.controller.sysmodule.ModuleRestController;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.SysModuleService;
import com.goku.coreui.sys.service.SysUserService;
import com.goku.coreui.sys.util.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nbfujx on 2018/1/10.
 */
@RestController
@RequestMapping("/api/sys/module")
public class ModuleRestControllerImpl implements ModuleRestController {

    @Autowired
    SysModuleService sysModuleService;

    @Autowired
    PageUtil pageUtil;

    @RequestMapping("/getModuleForPaging")
    //@RequiresPermissions(value={"sys:module:query"})
    public String  getModuleForPaging()
    {
        TablePage tp= pageUtil.getDataForPaging(sysModuleService.getModuleForPaging());
        return JSON.toJSONString (tp);
    }
}
