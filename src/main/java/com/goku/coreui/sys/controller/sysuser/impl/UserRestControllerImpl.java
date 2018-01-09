package com.goku.coreui.sys.controller.sysuser.impl;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.SysUserService;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import com.goku.coreui.sys.util.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    PageUtil pageUtil;

    @Autowired
    SysUserService sysUserService;

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

    @RequestMapping("/getUserForPaging")
    @RequiresPermissions(value={"sys:user:query"})
    public String  getUserForPaging(@RequestParam(required=false) String username, @RequestParam(required=false)  String name,
                                    @RequestParam(required=false)  String sortName, @RequestParam(required=false)  String sortOrder,
                                    @RequestParam int pageNumber, @RequestParam int pageSize)
    {
        TablePage tp= pageUtil.getDataForPaging(sysUserService.getUserForPaging(username,name,sortName,sortOrder,pageNumber,pageSize));
        return JSON.toJSONString (tp);
    }
}
