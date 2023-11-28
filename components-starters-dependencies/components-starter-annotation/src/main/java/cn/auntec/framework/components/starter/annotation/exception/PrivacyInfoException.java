package cn.auntec.framework.components.starter.annotation.exception;

import cn.auntec.framework.components.core.exception.AuntecRuntimeException;
import cn.auntec.framework.components.starter.annotation.exception.code.WebAnnotationExceptionCode;

/**
 * PrivacyInfoException class
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class PrivacyInfoException extends AuntecRuntimeException {
    private static final long serialVersionUID = 8795029052309556328L;

    public PrivacyInfoException() {
        super(WebAnnotationExceptionCode.PRIVACY_INFO);
    }
}
