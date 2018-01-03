package com.goku.coreui.sys.util;

import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/28.
 */
@Component
public class BreadcrumbUtil {

    @Autowired
    SysMenuService sysMenuService;

    public  List<Breadcrumb> getBreadcrumbPath(String menuUrl)
    {
        List<Breadcrumb> breadcrumbs=new ArrayList<Breadcrumb>();
        SysMenu sysMenu=sysMenuService.getMenuByUrl(menuUrl);
        if("-1".equals(sysMenu.getParentId()))
        {
            //当前菜单
            Breadcrumb bd=new Breadcrumb();
            bd.setName(sysMenu.getName());
            bd.setOrder(10);
            bd.setIsleaf("Y");
            breadcrumbs.add(bd);
            //模块
            Breadcrumb bd2=new Breadcrumb();
            bd2.setName("系统模块");
            bd2.setOrder(0);
            bd2.setIsleaf("N");
            breadcrumbs.add(bd2);
        }else
        {
            //当前菜单
            Breadcrumb bd=new Breadcrumb();
            bd.setName(sysMenu.getName());
            bd.setOrder(10);
            bd.setUrl(sysMenu.getUrl());
            bd.setIsleaf("Y");
            breadcrumbs.add(bd);
            //父级菜单
            List<Breadcrumb> parentBreadcrumb=getParentBreadcrumb(sysMenu.getParentId(),9);
            breadcrumbs.addAll(parentBreadcrumb);
            //模块
            Breadcrumb bd2=new Breadcrumb();
            bd2.setName("系统模块");
            bd2.setOrder(0);
            bd2.setIsleaf("N");
            breadcrumbs.add(bd2);
        }
        Collections.reverse(breadcrumbs);
        return breadcrumbs;
    }

    public List<Breadcrumb> getParentBreadcrumb(String parentId,int index)
    {
        List<Breadcrumb> breadcrumbs=new ArrayList<Breadcrumb>();
        SysMenu sysMenu=sysMenuService.getMenuByMenuId(parentId);
        if("-1".equals(sysMenu.getParentId()))
        {
            //当前菜单
            Breadcrumb bd=new Breadcrumb();
            bd.setName(sysMenu.getName());
            bd.setOrder(index);
            bd.setIsleaf("N");
            breadcrumbs.add(bd);
        }else
        {
            //当前菜单
            Breadcrumb bd=new Breadcrumb();
            bd.setName(sysMenu.getName());
            bd.setOrder(index);
            bd.setUrl(sysMenu.getUrl());
            bd.setIsleaf("N");
            breadcrumbs.add(bd);
            //父级菜单
            List<Breadcrumb> parentBreadcrumb=getParentBreadcrumb(sysMenu.getParentId(),index-1);
            breadcrumbs.addAll(parentBreadcrumb);
        }
        return breadcrumbs;
    }

}
