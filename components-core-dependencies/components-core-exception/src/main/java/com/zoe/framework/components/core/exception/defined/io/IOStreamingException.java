package com.zoe.framework.components.core.exception.defined.io;


import com.zoe.framework.components.core.exception.ZoeRuntimeException;
import com.zoe.framework.components.core.exception.common.CommonExceptionCode;

/**
 * IO流异常
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class IOStreamingException extends ZoeRuntimeException {

    private static final long serialVersionUID = 4175735482521945662L;

    public IOStreamingException() {
        super(CommonExceptionCode.IO_STREAMING);
    }

    public IOStreamingException(Throwable throwable) {
        super(CommonExceptionCode.IO_STREAMING, throwable);
    }

    public IOStreamingException(String message) {
        super(CommonExceptionCode.IO_STREAMING, message);
    }

    public IOStreamingException(String message, Throwable throwable) {
        super(CommonExceptionCode.IO_STREAMING, message, throwable);
    }
}
