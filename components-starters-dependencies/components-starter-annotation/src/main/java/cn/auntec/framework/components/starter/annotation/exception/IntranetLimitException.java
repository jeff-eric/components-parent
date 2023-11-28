package cn.auntec.framework.components.starter.annotation.exception;

import cn.auntec.framework.components.core.exception.AuntecRuntimeException;
import cn.auntec.framework.components.starter.annotation.exception.code.WebAnnotationExceptionCode;

/**
 * IntranetLimitException class
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class IntranetLimitException extends AuntecRuntimeException {
    private static final long serialVersionUID = -5339821299605718859L;

    public IntranetLimitException() {
        super(WebAnnotationExceptionCode.INTRANET_LIMIT);
    }
}
