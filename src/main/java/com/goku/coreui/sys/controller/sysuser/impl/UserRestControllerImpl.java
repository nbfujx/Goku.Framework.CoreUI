package com.goku.coreui.sys.controller.sysuser.impl;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nbfujx on 2017/12/25.
 */
@RestController
@RequestMapping("/api/sys/user")
public class UserRestControllerImpl {

    @Autowired
    BreadcrumbUtil breadcrumbUtil;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:user:query"})
    public String  list() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/user/getListPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:user:add"})
    public String  add() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/user/addPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:user:edit"})
    public String  edit() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/user/editPage");
        return JSON.toJSONString(Breadcrumbs);
    }
}
