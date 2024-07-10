package com.skrstop.framework.components.core.common.response.core;

import com.skrstop.framework.components.core.common.response.common.CommonResultCode;

import java.beans.Transient;
import java.io.Serializable;

/**
 * response code interface
 *
 * @author 蒋时华
 * @date 2018/7/19
 */
public interface IResult extends Serializable {

    /**
     * get response code
     *
     * @return int
     */
    String getCode();

    /**
     * set response code
     *
     * @param code
     */
    void setCode(String code);

    /**
     * get response message
     *
     * @return
     */
    String getMessage();

    /**
     * set response message
     *
     * @param message
     */
    void setMessage(String message);

    /**
     * 获取当前时间
     *
     * @return
     */
    Long getTimestamp();

    /**
     * 设置时间
     */
    void setTimestamp();

    /**
     * 是否成功
     *
     * @return
     */
    @Transient
    default boolean isSuccess() {
        return CommonResultCode.SUCCESS.getCode().equals(this.getCode());
    }

    @Transient
    default boolean isFailed() {
        return !isSuccess();
    }

}
