package com.jphoebe.framework.components.starter.web.exception.global.interceptor.exception;

import com.jphoebe.framework.components.core.common.response.core.IResult;
import com.jphoebe.framework.components.core.common.util.EnumCodeUtil;
import com.jphoebe.framework.components.core.exception.common.CommonExceptionCode;
import com.jphoebe.framework.components.starter.web.exception.core.interceptor.ExceptionHandlerInterceptor;
import com.jphoebe.framework.components.util.value.data.CollectionUtil;
import com.jphoebe.framework.components.util.value.validate.ErrorMessageUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 参数异常handle
 *
 * @author 蒋时华
 * @date 2020-05-08 13:03:01
 */
@Slf4j
@NoArgsConstructor
public class BindExceptionInterceptor implements ExceptionHandlerInterceptor {

    @Override
    public IResult execute(Exception e) {
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getBindingResult().getAllErrors();
            String defaultMessage = null;
            IResult error = EnumCodeUtil.transferEnumCode(CommonExceptionCode.PARAMETER);
            if (CollectionUtil.isNotEmpty(errors)) {
                defaultMessage = ErrorMessageUtil.getFirstErrorMessage(errors.stream()
                        .filter(err -> err instanceof FieldError && !((FieldError) err).isBindingFailure())
                        .map(ObjectError::getDefaultMessage)
                        .collect(Collectors.toList())
                );
            }
            error.setMessage(defaultMessage);
            return error;
        }
        return null;
    }

}
