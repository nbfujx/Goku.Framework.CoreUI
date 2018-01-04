package com.goku.coreui.sys.controller.home.impl;

import com.goku.coreui.sys.controller.home.HomeRestController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nbfujx on 2017/12/25.
 */
@RestController
@RequestMapping("/api")
public class HomeRestControllerImpl implements HomeRestController {

}
