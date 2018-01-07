package com.goku.coreui.sys.service;

import com.goku.coreui.sys.model.SysModule;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/1.
 */
public interface SysModuleService {
    List<SysModule> getUserModules(String UserId);
    SysModule selectByPrimaryKey(String id);
}
