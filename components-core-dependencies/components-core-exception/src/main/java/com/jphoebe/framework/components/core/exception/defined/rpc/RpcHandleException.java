package com.jphoebe.framework.components.core.exception.defined.rpc;

import com.jphoebe.framework.components.core.exception.AuntecRuntimeException;
import com.jphoebe.framework.components.core.exception.common.CommonExceptionCode;

/**
 * rpc异常
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class RpcHandleException extends AuntecRuntimeException {

    private static final long serialVersionUID = 798284573877750017L;

    public RpcHandleException() {
        super(CommonExceptionCode.RPC_HANDLE);
    }

    public RpcHandleException(Throwable throwable) {
        super(CommonExceptionCode.RPC_HANDLE, throwable);
    }

    public RpcHandleException(String message) {
        super(CommonExceptionCode.RPC_HANDLE, message);
    }

    public RpcHandleException(String message, Throwable throwable) {
        super(CommonExceptionCode.RPC_HANDLE, message, throwable);
    }
}
