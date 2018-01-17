package com.goku.coreui.sys.controller.index;

import com.goku.coreui.sys.config.log.LoggerInfo;
import org.springframework.ui.Model;

/**
 * Created by nbfujx on 2017/12/25.
 */
public interface IndexController {

    @LoggerInfo(Method = "/sys/index",Name = "系统模块首页")
    String  index(Model model);
}
