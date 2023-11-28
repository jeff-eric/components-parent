package cn.auntec.framework.components.starter.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 隐私信息限制
 *
 * @author 蒋时华
 * @date 2019/4/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface PrivacyInfoValue {
    // 是否限制内网访问
    boolean limitIntranet() default false;
}
