package com.goku.coreui.sys.controller.sysmodule;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.ui.Model;

/**
 * Created by nbfujx on 2018/1/10.
 */
public interface ModuleController {
    @LoggerInfo(Method = "/sys/module/getListPage",Name = "查看模块列表")
    String list(Model model);
    @LoggerInfo(Method = "/sys/module/addPage",Name = "模块新增")
    String  add(Model model);
    @LoggerInfo(Method = "/sys/module/editPage",Name = "模块修改")
    String  edit(String menuId, Model model);
}
