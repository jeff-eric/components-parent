package cn.auntec.framework.components.starter.annotation.exception;


import cn.auntec.framework.components.core.exception.AuntecRuntimeException;
import cn.auntec.framework.components.starter.annotation.exception.code.WebAnnotationExceptionCode;

/**
 * AccessLimitException class
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class AccessLimitException extends AuntecRuntimeException {
    private static final long serialVersionUID = 1205620779302704041L;

    public AccessLimitException() {
        super(WebAnnotationExceptionCode.ACCESS_LIMIT);
    }
}
