package com.skrstop.framework.components.starter.annotation.handle.server.processor.asserts;

/**
 * @author 蒋时华
 * @date 2022-03-01 15:46:22
 */
public class DefaultAssert implements ProcessorAssert<Object> {

    @Override
    public boolean isSupported(Object currentValue) {
        return false;
    }
}
