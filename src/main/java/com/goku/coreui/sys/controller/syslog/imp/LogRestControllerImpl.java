package com.goku.coreui.sys.controller.syslog.imp;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.controller.syslog.LogRestController;
import com.goku.coreui.sys.model.ext.Breadcrumb;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.SysLogService;
import com.goku.coreui.sys.util.BreadcrumbUtil;
import com.goku.coreui.sys.util.DateUtil;
import com.goku.coreui.sys.util.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/16.
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/sys/log")
public class LogRestControllerImpl implements LogRestController {


    @Autowired
    SysLogService sysLogService;

    @Autowired
    BreadcrumbUtil breadcrumbUtil;

    @Autowired
    PageUtil pageUtil;

    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:log:query"})
    public String  list() {
        List<Breadcrumb> Breadcrumbs= breadcrumbUtil.getBreadcrumbPath("sys/log/getListPage");
        return JSON.toJSONString(Breadcrumbs);
    }

    @Override
    @RequestMapping("/getLogForPaging")
    @RequiresPermissions(value={"sys:log:query"})
    public String  getLogForPaging(@RequestParam(required=false) String username,
                                    @RequestParam(required=false)  String begindate,
                                    @RequestParam(required=false) String  enddate,
                                    @RequestParam int pageNumber, @RequestParam int pageSize){

        TablePage tp= pageUtil.getDataForPaging(sysLogService.getLogForPaging(username, DateUtil.StrtoDate(begindate,"yyyy-MM-dd"),DateUtil.StrtoDate(enddate,"yyyy-MM-dd"),pageNumber,pageSize));
        return JSON.toJSONString (tp);
    }

}
