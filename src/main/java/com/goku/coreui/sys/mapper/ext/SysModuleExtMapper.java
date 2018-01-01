package com.goku.coreui.sys.mapper.ext;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/30.
 */
public interface SysModuleExtMapper {
   List<HashMap<String,String>> getUserModules(String UserId);
}
