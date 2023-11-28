package com.jphoebe.framework.components.util.media.exception.image;

import com.jphoebe.framework.components.core.exception.AuntecRuntimeException;
import com.jphoebe.framework.components.util.media.exception.CommonExceptionCode;

/**
 * 图片处理异常
 *
 * @author 蒋时华
 * @date 2019/6/3
 */
public class ImageHandleException extends AuntecRuntimeException {

    private static final long serialVersionUID = -1919727120140467060L;

    public ImageHandleException() {
        super(CommonExceptionCode.IMAGE_HANLE);
    }

    public ImageHandleException(Throwable throwable) {
        super(CommonExceptionCode.IMAGE_HANLE, throwable);
    }

    public ImageHandleException(String message) {
        super(CommonExceptionCode.IMAGE_HANLE, message);
    }

    public ImageHandleException(String message, Throwable throwable) {
        super(CommonExceptionCode.IMAGE_HANLE, message, throwable);
    }
}
