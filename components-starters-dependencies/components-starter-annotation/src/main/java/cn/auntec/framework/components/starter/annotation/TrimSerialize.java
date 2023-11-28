package cn.auntec.framework.components.starter.annotation;

import cn.auntec.framework.components.starter.annotation.trim.TrimJacksonFormatterSerializer;
import cn.auntec.framework.components.starter.annotation.trim.TrimmerType;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

/**
 * @author 蒋时华
 * @date 2021-02-24 14:41:23
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside
@JsonSerialize(using = TrimJacksonFormatterSerializer.class)
public @interface TrimSerialize {

    TrimmerType value() default TrimmerType.LEFT_RIGHT;
}
