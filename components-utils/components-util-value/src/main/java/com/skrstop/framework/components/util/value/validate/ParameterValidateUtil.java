package com.skrstop.framework.components.util.value.validate;

import cn.hutool.core.util.StrUtil;
import com.skrstop.framework.components.core.exception.defined.illegal.ParameterException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.experimental.UtilityClass;
import org.hibernate.validator.HibernateValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 蒋时华
 */
@UtilityClass
public class ParameterValidateUtil {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    private static final Validator HIBERNATE_VALIDATOR = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * spring validate 框架参数验证，并抛出异常
     *
     * @param t
     * @param <T>
     */
    public static <T> void validate(T t) {
        List<String> errorMessage = validateMessage(t);
        // 抛出检验异常
        if (errorMessage.size() > 0) {
            throw new ParameterException(StrUtil.format("参数校验失败:{}", ErrorMessageUtil.getFirstErrorMessage(errorMessage)));
        }
    }

    /**
     * spring validate 框架参数验证, 返回错误message 列表
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<String> validateMessage(T t) {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(t);
        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            messageList.add(constraintViolation.getMessage());
        }
        return ErrorMessageUtil.getErrorMessage(messageList);
    }

    /**
     * hibernate validate 框架参数验证，并抛出异常
     *
     * @param obj
     * @param <T>
     */
    public static <T> void hibernateValidate(T obj) {
        List<String> errorMessage = hibernateValidateMessage(obj);
        // 抛出检验异常
        if (errorMessage.size() > 0) {
            throw new ParameterException(StrUtil.format("参数校验失败:{}", ErrorMessageUtil.getErrorMessage(errorMessage)));
        }
    }

    /**
     * hibernate validate 框架参数验证, 返回错误message 列表
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> List<String> hibernateValidateMessage(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = HIBERNATE_VALIDATOR.validate(obj);
        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            messageList.add(constraintViolation.getMessage());
        }
        return ErrorMessageUtil.getErrorMessage(messageList);
    }

}
