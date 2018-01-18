package com.goku.coreui.sys.controller.sysuser;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.ui.Model;

/**
 * Created by nbfujx on 2017/12/25.
 */

public interface UserController {
    @LoggerInfo(Method = "/sys/user/getListPage",Name = "用户列表")
    String list(Model model);
    @LoggerInfo(Method = "/sys/user/addPage",Name = "用户新增")
    String  add(Model model);
    @LoggerInfo(Method = "/sys/user/editPage",Name = "用户修改")
    String  edit(Model model);
}
