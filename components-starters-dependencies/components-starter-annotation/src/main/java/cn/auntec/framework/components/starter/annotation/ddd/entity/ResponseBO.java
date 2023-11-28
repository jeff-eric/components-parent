package cn.auntec.framework.components.starter.annotation.ddd.entity;

import cn.auntec.framework.components.util.constant.StringPoolConst;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author 蒋时华
 * @date 2021-03-17 09:52:21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@BO(scope = ObjectScope.RESPONSE)
public @interface ResponseBO {

    @AliasFor(annotation = BO.class)
    String value() default StringPoolConst.EMPTY;

    @AliasFor(annotation = BO.class)
    String remark() default StringPoolConst.EMPTY;

}
