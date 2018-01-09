package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/4.
 */
public interface SysUserExtMapper {
     SysUser getUserByUsername(@Param("username") String username);
     List<SysUser> getUserForPaging(@Param("username")String username, @Param("name") String name,
                                    @Param("orderFiled") String orderFiled, @Param("orderSort") String orderSort);
}
