package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysLogMapper;
import com.goku.coreui.sys.mapper.SysMenuMapper;
import com.goku.coreui.sys.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/16.
 */
public interface SysLogExtMapper extends SysLogMapper {
 List<SysLog> getLogForPaging(@Param("username") String username, @Param("begindate") Date begindate,@Param("enddate")  Date enddate);
}
