package cn.auntec.framework.components.util.value.validate.validator;

import cn.auntec.framework.components.util.constant.StringPoolConst;
import cn.auntec.framework.components.util.value.data.ObjectUtil;
import cn.auntec.framework.components.util.value.data.StringLengthUtil;
import cn.auntec.framework.components.util.value.validate.annotation.LengthSize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 蒋时华
 * @date 2020-09-27 19:36:34
 */
public class LengthStrConstraintValidatorForObj implements ConstraintValidator<LengthSize, Object> {

    private boolean size;
    private String charset;
    private long min;
    private long max;
    private boolean ignoreNull;

    @Override
    public void initialize(LengthSize constraintAnnotation) {
        charset = constraintAnnotation.charset();
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        size = constraintAnnotation.size();
        ignoreNull = constraintAnnotation.ignoreNull();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (ignoreNull && ObjectUtil.isNull(value)) {
            return true;
        }
        String test = ObjectUtil.isNull(value) ? StringPoolConst.EMPTY : value.toString();
        if (size) {
            long size = test.length();
            return (size >= min && size <= max);
        }
        return StringLengthUtil.gtAndlt(test, min, max, charset);
    }
}
