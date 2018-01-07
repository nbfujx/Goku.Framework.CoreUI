package com.goku.coreui.sys.config.shiro;

import com.goku.coreui.sys.mapper.ext.SysMenuExtMapper;
import com.goku.coreui.sys.mapper.ext.SysUserExtMapper;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nbfujx on 2017/11/7.
 */
public class ShiroRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SysUserExtMapper sysuserextmapper;
    @Autowired
    SysMenuExtMapper sysmenuextmapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = sysuserextmapper.getUserByUsername((String) principalCollection.getPrimaryPrincipal());
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        for(SysRole userRole:user.getSysRoleList()){
            info.addRole(userRole.getKey());
        }
        //赋予权限
        for(SysMenu menu:sysmenuextmapper.getMenuByUserId(user.getId())){
            if(!"".equals(menu.getPermission())) {
                this.logger.info(menu.getPermission());
                info.addStringPermission(menu.getPermission());
            }
        }

        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        SysUser user = sysuserextmapper.getUserByUsername(token.getUsername());
        if (user != null) {
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
    }
}
