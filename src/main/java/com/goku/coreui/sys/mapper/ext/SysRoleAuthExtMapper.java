package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysRoleAuthMapper;
import com.goku.coreui.sys.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2018/2/5.
 */
public interface SysRoleAuthExtMapper extends SysRoleAuthMapper {
    int deleteRoleAuthByModuleId(@Param("roleid") String roleid, @Param("id") String id);
}
