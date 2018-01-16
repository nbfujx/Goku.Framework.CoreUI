package com.goku.coreui.sys.config.log;

import com.alibaba.fastjson.JSON;
import com.goku.coreui.sys.mapper.ext.SysLogExtMapper;
import com.goku.coreui.sys.model.SysLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nbfujx on 2017-11-22.
 */
@Aspect
@Order(-98) // 控制多个Aspect的执行顺序，越小越先执行
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Autowired
    SysLogExtMapper syslogmapper;

    @After("execution(* com.goku.coreui.**.controller..*.*(..))")
    public void After(JoinPoint point){
        Object target = point.getTarget();
        this.logger.info(target.toString());
        String method = point.getSignature().getName();
        this.logger.info(method);
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(LoggerInfo.class)) {
                LoggerInfo loggerinfo = m.getAnnotation(LoggerInfo.class);
                Subject subject = SecurityUtils.getSubject();
                this.logger.info("oper："+loggerinfo.Name()+"|"+"method"+ loggerinfo.Method());
                SysLog syslog=new SysLog();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                syslog.setId(uuid);
                syslog.setUsername((String) subject.getPrincipal());
                syslog.setIp(subject.getSession().getHost());
                syslog.setOperation(loggerinfo.Name());
                syslog.setMethod(loggerinfo.Method());
                syslog.setParams(JSON.toJSONString (point.getArgs()));
                syslog.setCreateDate(new Date());
                syslogmapper.insert(syslog);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
