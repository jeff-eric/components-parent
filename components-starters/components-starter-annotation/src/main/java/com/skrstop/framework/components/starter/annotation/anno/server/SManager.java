package com.skrstop.framework.components.starter.annotation.anno.server;

import com.skrstop.framework.components.util.constant.StringPoolConst;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 蒋时华
 * @date 2021-03-17 09:52:21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SManager {

    @AliasFor(annotation = Component.class)
    String value() default StringPoolConst.EMPTY;

}
