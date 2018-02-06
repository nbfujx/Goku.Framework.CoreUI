package com.goku.coreui.sys.controller.sysuser.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.goku.coreui.sys.controller.sysuser.UserRestController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.SysUserService;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import com.goku.coreui.sys.util.CamelUtil;
import com.goku.coreui.sys.util.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017/12/25.
 */
@RestController
@RequestMapping("/api/sys/user")
public class UserRestControllerImpl implements UserRestController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    BreadcrumbUtil breadcrumbUtil;

    @Autowired
    PageUtil pageUtil;

    @Autowired
    CamelUtil camelUtil;

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

    @RequestMapping("/menuAuthPage")
    @RequiresPermissions(value={"sys:user:menuauth"})
    public String  menuauth() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/user/menuAuthPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/roleAuthPage")
    @RequiresPermissions(value={"sys:user:roleauth"})
    public String  roleauth() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/user/roleAuthPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @RequestMapping("/getUserForPaging")
    @RequiresPermissions(value={"sys:user:query"})
    public String  getUserForPaging(@RequestParam(required=false) String username, @RequestParam(required=false)  String name,
                                    @RequestParam(required=false)  String sortName, @RequestParam(required=false)  String sortOrder,
                                    @RequestParam int pageNumber, @RequestParam int pageSize)
    {
        TablePage tp= pageUtil.getDataForPaging(sysUserService.getUserForPaging(username,name,camelUtil.camelToUnderline(sortName),sortOrder,pageNumber,pageSize));
        return JSON.toJSONString (tp);
    }

    @Override
    @RequestMapping("/menuauth")
    @RequiresRoles("admin_sys")
    @RequiresPermissions(value={"sys:user:menuauth"})
    public String menuauth(@RequestBody Map<String, Object> sys) {
        List<SysMenu> sysMenus = JSON.parseObject(String.valueOf(JSON.toJSON(sys.get("sysMenus"))), new TypeReference<List<SysMenu>>() {});
        String userid= (String) sys.get("userid");
        String moduleId= (String) sys.get("moduleId");
        int result=sysUserService.menuAuth(sysMenus,userid,moduleId);
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
    }

    @Override
    @RequestMapping("/roleauth")
    @RequiresRoles("admin_sys")
    @RequiresPermissions(value={"sys:user:roleauth"})
    public String roleauth(@RequestBody Map<String, Object> sys) {
        List<SysRole> sysRoles = JSON.parseObject(String.valueOf(JSON.toJSON(sys.get("sysRoles"))), new TypeReference<List<SysRole>>() {});
        String userid= (String) sys.get("userid");
        int result=sysUserService.roleauth(sysRoles,userid);
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
    }
}
