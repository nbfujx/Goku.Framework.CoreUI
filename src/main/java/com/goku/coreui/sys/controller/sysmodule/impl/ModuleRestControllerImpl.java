package com.goku.coreui.sys.controller.sysmodule.impl;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.controller.sysmodule.ModuleRestController;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.SysModuleService;
import com.goku.coreui.sys.service.SysUserService;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import com.goku.coreui.sys.util.CamelUtil;
import com.goku.coreui.sys.util.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/10.
 */
@RestController
@RequestMapping("/api/sys/module")
public class ModuleRestControllerImpl implements ModuleRestController {

    @Autowired
    SysModuleService sysModuleService;

    @Autowired
    BreadcrumbUtil breadcrumbUtil;

    @Autowired
    PageUtil pageUtil;

    @Autowired
    CamelUtil camelUtil;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:module:query"})
    public String  list() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/module/getListPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:module:add"})
    public String  add() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/module/addPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:module:edit"})
    public String  edit() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/module/editPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/getModuleForPaging")
    @RequiresPermissions(value={"sys:module:query"})
    public String  getModuleForPaging()
    {
        TablePage tp= pageUtil.getDataForPaging(sysModuleService.getModuleForPaging());
        return JSON.toJSONString (tp);
    }
}
