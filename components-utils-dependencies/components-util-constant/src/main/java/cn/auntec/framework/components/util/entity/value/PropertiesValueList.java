package cn.auntec.framework.components.util.entity.value;

import cn.auntec.framework.components.core.common.serializable.SerializableBean;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @author 蒋时华
 * @date 2021-04-21 10:19:53
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class PropertiesValueList extends SerializableBean implements PropertiesValue {
    private static final long serialVersionUID = 7509071702432520408L;

    private List<ValueItem> value;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Accessors(chain = true)
    public static class ValueItem extends SerializableBean {
        private static final long serialVersionUID = 8550751305838267164L;

        private String key;
        private String name;
        private String description;
        private String value;
        /*** 单位 */
        private String unitType;
        /*** 单位描述 */
        private String unitTitle;
        /*** 扩展信息 */
        private Map<String, Object> extra;
        private Object extend;
        /*** 作用域 */
        private String scope;
    }


}
