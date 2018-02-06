package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysUserAuthMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by nbfujx on 2018/2/6.
 */
public interface SysUserAuthExtMapper extends SysUserAuthMapper {
  int deleteUserAuthByModuleId(@Param("userid") String roleid, @Param("id") String id);
}
