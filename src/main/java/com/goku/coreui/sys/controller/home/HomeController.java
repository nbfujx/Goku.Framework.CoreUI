package com.goku.coreui.sys.controller.home;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nbfujx on 2017/12/25.
 */
public interface HomeController {

    String login(Model model);

    @LoggerInfo(Method = "/doLogin",Name = "登录")
    String doLogin(String userName,String password,Model model);

    @LoggerInfo(Method = "/logout",Name = "登出")
    String logout();

    @LoggerInfo(Method = "/home",Name = "查看首页")
    String home(Model model, String moduleId);
}
