package com.jphoebe.framework.components.util.value.lambda;

import java.io.Serializable;

/**
 * SFunction class
 *
 * @author 蒋时华
 * @date 2019/12/14
 */
@FunctionalInterface
public interface GetterFunction<T> extends Serializable {
    Object get(T source);
}
