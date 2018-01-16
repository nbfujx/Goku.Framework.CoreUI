package com.goku.coreui.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.mapper.ext.SysLogExtMapper;
import com.goku.coreui.sys.model.SysLog;
import com.goku.coreui.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/16.
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogExtMapper syslogextmapper;

    @Override
    public PageInfo getLogForPaging(String username, Date begindate, Date enddate, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<SysLog> list = syslogextmapper.getLogForPaging(username, begindate,enddate);
        PageInfo page = new PageInfo(list);
        return page;
    }
}
