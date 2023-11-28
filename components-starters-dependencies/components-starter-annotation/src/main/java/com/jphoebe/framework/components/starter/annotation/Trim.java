package com.jphoebe.framework.components.starter.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jphoebe.framework.components.starter.annotation.trim.TrimJacksonFormatterDeserializer;
import com.jphoebe.framework.components.starter.annotation.trim.TrimmerType;

import java.lang.annotation.*;

/**
 * @author 蒋时华
 * @date 2021-02-24 14:41:23
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside
@JsonDeserialize(using = TrimJacksonFormatterDeserializer.class)
public @interface Trim {

    TrimmerType value() default TrimmerType.LEFT_RIGHT;
}
