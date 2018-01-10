package com.goku.coreui.sys.mapper.ext;

import com.goku.coreui.sys.mapper.SysModuleMapper;
import com.goku.coreui.sys.model.SysModule;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/30.
 */
public interface SysModuleExtMapper extends SysModuleMapper {
   List<SysModule> getUserModules(@Param("UserId")  String UserId);
   List<SysModule> getModuleForPaging();

}
