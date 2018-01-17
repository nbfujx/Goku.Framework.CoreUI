package com.goku.coreui.sys.controller.sysmenu;

import com.goku.coreui.sys.config.log.LoggerInfo;
import com.goku.coreui.sys.model.SysMenu;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by nbfujx on 2018/1/10.
 */
public interface MenuRestController {
    @LoggerInfo(Method = "/api/sys/menu/save",Name = "菜单新增")
    String  save( SysMenu symenu);
    @LoggerInfo(Method = "/api/sys/menu/delete",Name = "菜单删除")
    String  delete(String menuId);
}
