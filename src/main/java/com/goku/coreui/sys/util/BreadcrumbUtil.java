package com.goku.coreui.sys.util;

import com.goku.coreui.sys.model.ext.Breadcrumb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/28.
 */
public class BreadcrumbUtil {

    public static List<Breadcrumb> getBreadcrumbPath(String menuNane)
    {
        List<Breadcrumb> breadcrumbs=new ArrayList<Breadcrumb>();
        Breadcrumb bd=new Breadcrumb();
        bd.setName("系统模块");
        bd.setOrder(0);
        bd.setIsleaf("N");
        breadcrumbs.add(bd);
        Breadcrumb bd2=new Breadcrumb();
        bd2.setName("系统管理");
        bd2.setOrder(1);
        bd2.setIsleaf("N");
        breadcrumbs.add(bd2);
        Breadcrumb bd3=new Breadcrumb();
        bd3.setName("权限管理");
        bd3.setOrder(2);
        bd3.setUrl("sys/user/getListPage");
        bd3.setIsleaf("N");
        breadcrumbs.add(bd3);
        Breadcrumb bd4=new Breadcrumb();
        bd4.setName("新增");
        bd4.setOrder(2);
        bd4.setUrl("sys/user/getAddPage");
        bd4.setIsleaf("Y");
        breadcrumbs.add(bd4);
        return breadcrumbs;
    }
}
