package com.zoe.framework.components.starter.annotation.anno.server;

import com.zoe.framework.components.util.constant.StringPoolConst;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author 蒋时华
 * @date 2021-03-17 09:52:21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface SRestCtlEndpoint {

    @AliasFor(annotation = RestController.class)
    String value() default StringPoolConst.EMPTY;

}
