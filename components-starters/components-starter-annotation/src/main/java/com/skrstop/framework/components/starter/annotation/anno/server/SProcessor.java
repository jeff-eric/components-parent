package com.skrstop.framework.components.starter.annotation.anno.server;

import com.skrstop.framework.components.starter.annotation.handle.server.processor.ProcessorContext;
import com.skrstop.framework.components.util.constant.StringPoolConst;
import org.springframework.core.Ordered;
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
@Repeatable(SProcessors.class)
public @interface SProcessor {

    @AliasFor(annotation = Component.class)
    String value() default StringPoolConst.EMPTY;

    /**
     * 处理器容器名字
     */
    String containerName() default ProcessorContext.DEFAULT_CONTAINERS_NAME;

    /**
     * 处理器名字, 默认：beanName
     */
    String processorName() default StringPoolConst.EMPTY;

    /**
     * 处理器描述
     *
     * @return
     */
    String description() default StringPoolConst.EMPTY;

    /**
     * 处理器满足条件判断，多个处理器满足条件的情况下 按照顺序默认取第一个。
     * 当为空时，默认取值assertBeanClass
     * 断言类寻找循序：assertBeanName -> assertBeanClass -> assertClass -> 处理类本身是否实现ProcessorAssert接口
     *
     * @see com.skrstop.framework.components.starter.annotation.handle.server.processor.asserts.ProcessorAssert
     */
    String assertBeanName() default StringPoolConst.EMPTY;

    /**
     * 处理器满足条件判断，多个处理器满足条件的情况下 按照顺序默认取第一个。
     * 当为空时，默认取值assertClass
     * 断言类寻找循序：assertBeanName -> assertBeanClass -> assertClass -> 处理类本身是否实现ProcessorAssert接口
     *
     * @see com.skrstop.framework.components.starter.annotation.handle.server.processor.asserts.ProcessorAssert
     */
    Class<?> assertBeanClass() default void.class;

    /**
     * 处理器满足条件判断
     * 当为空时，将检查该processor是否实现了ProcessorAssert接口
     * 如未实现，则默认不满足任何条件
     *
     * @see com.skrstop.framework.components.starter.annotation.handle.server.processor.asserts.ProcessorAssert
     * @see com.skrstop.framework.components.starter.annotation.handle.server.processor.asserts.DefaultAssert
     * 断言类寻找循序：assertBeanName -> assertBeanClass -> assertClass -> 处理类本身是否实现ProcessorAssert接口
     */
    Class<?> assertClass() default void.class;

    /**
     * 是否是默认的处理器，当找不到对应的处理器时，默认使用该处理器，多个默认处理器, 按照顺序默认取第一个
     */
    boolean defaultProcessor() default false;

    /**
     * 顺序，值越小，优先级越高
     */
    int ordered() default Ordered.HIGHEST_PRECEDENCE;

}
