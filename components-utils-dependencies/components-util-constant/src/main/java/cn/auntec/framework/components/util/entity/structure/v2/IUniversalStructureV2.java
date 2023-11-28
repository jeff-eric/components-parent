package cn.auntec.framework.components.util.entity.structure.v2;

import cn.auntec.framework.components.util.constant.StringPoolConst;

/**
 * @author 蒋时华
 * @date 2021-04-21 10:17:22
 */
public interface IUniversalStructureV2 {

    /**
     * 获取类型
     *
     * @return
     */
    default String getType() {
        return StringPoolConst.EMPTY;
    }

    /**
     * 获取名字
     *
     * @return
     */
    default String getName() {
        return StringPoolConst.EMPTY;
    }

    /**
     * 获取别名
     *
     * @return
     */
    default String getAlias() {
        return StringPoolConst.EMPTY;
    }

}
