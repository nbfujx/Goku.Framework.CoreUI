package com.goku.coreui.sys.controller.sysmenu;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

/**
 * Created by nbfujx on 2018/1/10.
 */
public interface MenuController {
    @LoggerInfo(Method = "/sys/menu/getListPage",Name = "查看菜单列表")
    String list(String moduleId, Model model);
    @LoggerInfo(Method = "/sys/menu/addPage",Name = "菜单新增")
    String  add(String moduleId, Model model);
    @LoggerInfo(Method = "/sys/menu/editPage",Name = "菜单修改")
    String  edit(String menuId, Model model);
}
