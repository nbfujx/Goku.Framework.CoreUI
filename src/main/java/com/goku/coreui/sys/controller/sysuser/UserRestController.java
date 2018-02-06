package com.goku.coreui.sys.controller.sysuser;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Created by nbfujx on 2017/12/25.
 */

public interface UserRestController {
    @LoggerInfo(Method = "/api/sys/role/menuauth",Name = "用户菜单赋值")
    String menuauth(@RequestBody Map<String, Object> sys);
    @LoggerInfo(Method = "/api/sys/role/menuauth",Name = "用户权限赋值")
    String roleauth(@RequestBody Map<String, Object> sys);
}
