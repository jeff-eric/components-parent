package cn.auntec.framework.components.core.common.util;

import cn.auntec.framework.components.core.common.response.CollectionResult;
import cn.auntec.framework.components.core.common.response.DefaultResult;
import cn.auntec.framework.components.core.common.response.Result;
import cn.auntec.framework.components.core.common.response.core.ICollectionResult;
import cn.auntec.framework.components.core.common.response.core.IDataResult;
import cn.auntec.framework.components.core.common.response.core.IResult;

/**
 * @author 蒋时华
 * @date 2020-05-08 15:07:20
 */
public class EnumCodeUtil {

    public static IResult transferEnumCode(IResult iResult) {
        if (iResult instanceof Enum) {
            return DefaultResult.Builder.result(iResult);
        }
        return iResult;
    }

    public static <T> IDataResult<T> transferEnumCode(IDataResult<T> iDataResult) {
        if (iDataResult instanceof Enum) {
            return Result.Builder.result(iDataResult);
        }
        return iDataResult;
    }

    public static <T> ICollectionResult<T> transferEnumCode(ICollectionResult<T> iListResult) {
        if (iListResult instanceof Enum) {
            return CollectionResult.Builder.result(iListResult);
        }
        return iListResult;
    }

}
