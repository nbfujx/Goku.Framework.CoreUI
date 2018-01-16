package com.goku.coreui.sys.config.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nbfujx on 2017-11-22.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggerInfo {
     String Method() default "";
     String Name() default "";
}
