package cn.auntec.framework.components.core.exception.defined.illegal;

import cn.auntec.framework.components.core.exception.AuntecRuntimeException;
import cn.auntec.framework.components.core.exception.common.CommonExceptionCode;

/**
 * 参数异常
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class ParameterException extends AuntecRuntimeException {

    private static final long serialVersionUID = -7255813596600201785L;

    public ParameterException() {
        super(CommonExceptionCode.PARAMETER);
    }

    public ParameterException(Throwable throwable) {
        super(CommonExceptionCode.PARAMETER, throwable);
    }

    public ParameterException(String message) {
        super(CommonExceptionCode.PARAMETER, message);
    }

    public ParameterException(String message, Throwable throwable) {
        super(CommonExceptionCode.PARAMETER, message, throwable);
    }
}
