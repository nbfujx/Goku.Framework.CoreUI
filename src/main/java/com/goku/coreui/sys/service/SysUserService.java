package com.goku.coreui.sys.service;

import com.github.pagehelper.PageInfo;

/**
 * Created by nbfujx on 2018/1/9.
 */
public interface SysUserService {
    PageInfo getUserForPaging(String username, String name,String orderFiled, String orderSort, int pageindex, int pagenum);
}
