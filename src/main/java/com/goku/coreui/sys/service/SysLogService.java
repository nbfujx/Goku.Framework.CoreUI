package com.goku.coreui.sys.service;

import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/16.
 */
public interface SysLogService {
    PageInfo getLogForPaging(String username, Date begindate, Date enddate, int pageindex, int pagenum);
}
