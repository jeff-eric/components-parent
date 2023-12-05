package com.zoe.framework.components.starter.web.utils;

import cn.hutool.core.util.ObjectUtil;
import com.zoe.framework.components.util.constant.StringPoolConst;
import com.zoe.framework.components.util.enums.HttpContentTypeEnum;
import com.zoe.framework.components.util.serialization.json.FastJsonUtil;
import com.zoe.framework.components.util.value.validate.ParameterValidateUtil;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author: wangzh
 * @date: 2021/3/11 20:43
 * @description: desc...
 */
public class RequestBeanUtil {

    /**
     * request对象获取
     * form表单/json数据
     *
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(T data, Class<T> cls) {
        if (ObjectUtil.isNull(cls)) {
            return FastJsonUtil.toBean(StringPoolConst.EMPTY_JSON, cls);
        }
        HttpServletRequest request = WebUtil.getRequest();
        if (HttpContentTypeEnum.APPLICATION_JSON_UTF8.getContentType().contains(request.getContentType())) {
            String requestBody = RequestUtil.getRequestBody(request);
            return FastJsonUtil.toBean(requestBody, cls);
        }
        return data;
    }

    /**
     * 带参数校验的bean获取
     *
     * @param data
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBeanWithParamCheck(T data, Class<T> cls) {
        T bean = getBean(data, cls);
        // 参数校验
        ParameterValidateUtil.validate(bean);
        return bean;
    }
}
