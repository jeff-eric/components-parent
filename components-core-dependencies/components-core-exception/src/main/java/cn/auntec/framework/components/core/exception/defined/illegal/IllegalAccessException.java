package cn.auntec.framework.components.core.exception.defined.illegal;

import cn.auntec.framework.components.core.exception.AuntecRuntimeException;
import cn.auntec.framework.components.core.exception.common.CommonExceptionCode;

/**
 * 非法访问异常
 *
 * @author 蒋时华
 * @date 2019/9/9
 */
public class IllegalAccessException extends AuntecRuntimeException {

    private static final long serialVersionUID = 6505419698572898175L;

    public IllegalAccessException() {
        super(CommonExceptionCode.ILLEGAL_ACCESS);
    }

    public IllegalAccessException(Throwable throwable) {
        super(CommonExceptionCode.ILLEGAL_ACCESS, throwable);
    }

    public IllegalAccessException(String message) {
        super(CommonExceptionCode.ILLEGAL_ACCESS, message);
    }

    public IllegalAccessException(String message, Throwable throwable) {
        super(CommonExceptionCode.ILLEGAL_ACCESS, message, throwable);
    }
}
