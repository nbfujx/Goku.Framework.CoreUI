package com.goku.coreui.sys.controller.home.impl;

import com.goku.coreui.sys.config.log.LoggerInfo;
import com.goku.coreui.sys.controller.home.HomeController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysModule;
import com.goku.coreui.sys.model.SysUser;
import com.goku.coreui.sys.service.SysMenuService;
import com.goku.coreui.sys.service.impl.SysModuleServiceImpl;
import com.goku.coreui.sys.util.MenuTreeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
public class HomeControllerImpl implements HomeController,ErrorController {

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    MenuTreeUtil menuTreeUtil;

    @Autowired
    SysModuleServiceImpl sysModuleService;

    @Override
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @Override
    @RequestMapping("/doLogin")
    public String doLogin(
        @RequestParam(value = "username", required = true) String userName,
        @RequestParam(value = "password", required = true) String password,
        Model model)
    {
         String passwordmd5 = new Md5Hash(password, "2").toString();
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken token = new UsernamePasswordToken(userName, passwordmd5);
        try {
            subject.login(token);
            return "redirect:/home";
        }catch (UnknownAccountException e) {
            model.addAttribute("error", "账号不存在!");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("error","账号密码错误!");
            return "login";
        }catch (AuthenticationException e) {
            model.addAttribute("error","登录异常!请联系管理员!");
            return "login";
        }catch (Exception e) {
            model.addAttribute("error", "系统异常!");
            return "login";
        }
    }

    @Override
    @RequestMapping("/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.logout();
            return "login";
        } catch (SessionException ise) {
            return "500";
        } catch (Exception e) {
            return "500";
        }
    }

    @RequestMapping("/")
    public String defaultviews() {
        return "login";
    }

    @Override
    @RequestMapping("/home")
    public String home(Model model,@RequestParam(value="moduleId", required=false, defaultValue="") String moduleId) {
        //
        SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SecurityUtils.getSubject().getPrincipal());
        moduleId= "".equals(moduleId)?user.getSysUserInfo().getHomepage():moduleId;
        List<SysModule>  sysModules=sysModuleService.getUserModules(user.getId());
        SysModule sysModule=sysModuleService.selectByPrimaryKey(moduleId);
        if(sysModule==null){
            sysModule=sysModules.get(0);
        }
        List<SysMenu>   sysMens= menuTreeUtil.menuList(sysMenuService.getModuleMenus(sysModule.getId(),user.getId()));
        //List<SysNotice>  sysNotices=new ArrayList<SysNotice>();
        //List<SysSchedule>  sysSchedules=new ArrayList<SysSchedule>();
        //默认主模块为空
        if(sysModule==null){
            sysModule=sysModules.get(0);
        }
        model.addAttribute("sysModules",sysModules);
        model.addAttribute("sysMens",sysMens);
        model.addAttribute("module",sysModule);
        //model.addAttribute("sysNotices",sysNotices);
        //model.addAttribute("sysSchedules",sysSchedules);
        return "homepage";
    }

    @RequestMapping("/404")
    public String Unauthorized() {
        return "404";
    }

    @RequestMapping("/error")
    public String error()
    {
        return "500";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
