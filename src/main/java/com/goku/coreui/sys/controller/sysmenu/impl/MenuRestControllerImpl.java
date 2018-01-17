package com.goku.coreui.sys.controller.sysmenu.impl;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.controller.sysmenu.MenuRestController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.SysMenuService;
import com.goku.coreui.sys.service.SysUserService;
import com.goku.coreui.sys.service.impl.SysMenuServiceImpl;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import com.goku.coreui.sys.util.CamelUtil;
import com.goku.coreui.sys.util.PageUtil;
import com.goku.coreui.sys.util.TreeSelectUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/10.
 */
@RestController
@RequestMapping("/api/sys/menu")
public class MenuRestControllerImpl implements MenuRestController {


    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    BreadcrumbUtil breadcrumbUtil;

    @Autowired
    TreeSelectUtil treeSelectUtil;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:menu:query"})
    public String  list() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/menu/getListPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:menu:add"})
    public String  add() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/menu/addPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:menu:edit"})
    public String  edit() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/menu/editPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/getMenuForPaging")
    @RequiresPermissions(value={"sys:menu:query"})
    public String  getMenuForPaging(@RequestParam(value="moduleId", required=false, defaultValue="") String moduleId)
    {
        return JSON.toJSONString (sysMenuService.getMenuForPaging(moduleId));
    }

    @RequestMapping("/getMenuForTree")
    @RequiresPermissions(value={"sys:menu:query"})
    public String  getMenuForTree(@RequestParam(value="moduleId", required=false, defaultValue="") String moduleId)
    {
        return JSON.toJSONString (treeSelectUtil.TreeSelectList(sysMenuService.getMenuForPaging(moduleId)));
    }

    @Override
    @RequestMapping("/save")
    @RequiresPermissions(value={"sys:menu:add","sys:menu:edit"},logical = Logical.OR)
    public String  save(@RequestBody SysMenu symenu)
    {
        int result=sysMenuService.saveMenu(symenu);
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
    }

    @Override
    @RequestMapping("/delete")
    @RequiresPermissions(value={"sys:menu:delete"})
    public String  delete(@RequestBody String menuId)
    {
        menuId=menuId.replaceAll("\"","");
        int result=sysMenuService.deleteMenu(menuId);
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
    }
}
