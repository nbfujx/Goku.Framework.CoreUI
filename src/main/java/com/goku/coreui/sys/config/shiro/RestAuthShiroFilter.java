package com.goku.coreui.sys.config.shiro;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Created by nbfujx on 2018/1/14.
 */
public class RestAuthShiroFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        Subject subject = getSubject(servletRequest, servletResponse);
            if(subject.getPrincipal() == null) {
                PrintWriter out = null;
                try{
                    out = httpResponse.getWriter();
                    out.append(JSON.toJSONString (401));
                }catch(IOException e){
                    e.printStackTrace();
                }finally {
                    if (out != null) {
                        out.close();
                    }
                }
                return false;
            } else {
                return true;
            }
    }
}
