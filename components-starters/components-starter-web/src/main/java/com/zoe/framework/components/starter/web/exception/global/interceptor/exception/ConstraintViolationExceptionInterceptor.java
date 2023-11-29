package com.zoe.framework.components.starter.web.exception.global.interceptor.exception;

import com.zoe.framework.components.core.common.response.core.IResult;
import com.zoe.framework.components.core.common.util.EnumCodeUtil;
import com.zoe.framework.components.core.exception.common.CommonExceptionCode;
import com.zoe.framework.components.starter.web.exception.core.interceptor.ExceptionHandlerInterceptor;
import com.zoe.framework.components.util.value.data.CollectionUtil;
import com.zoe.framework.components.util.value.validate.ErrorMessageUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 参数异常handle
 *
 * @author 蒋时华
 * @date 2020-05-08 13:03:01
 */
@Slf4j
@NoArgsConstructor
public class ConstraintViolationExceptionInterceptor implements ExceptionHandlerInterceptor {

    @Override
    public IResult execute(Exception e) {
        if (e instanceof ConstraintViolationException) {
            IResult paramError = EnumCodeUtil.transferEnumCode(CommonExceptionCode.PARAMETER);
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            if (CollectionUtil.isEmpty(constraintViolations)) {
                return paramError;
            }
            List<String> errors = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            if (CollectionUtil.isEmpty(errors)) {
                return paramError;
            }
            paramError.setMessage(ErrorMessageUtil.getFirstErrorMessage(errors));
            return paramError;
        }
        return null;
    }

}
