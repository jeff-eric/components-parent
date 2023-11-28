package cn.auntec.framework.components.starter.annotation.ddd.processor;

import cn.auntec.framework.components.core.common.serializable.SerializableBean;
import cn.auntec.framework.components.starter.annotation.ddd.processor.asserts.ProcessorAssert;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author 蒋时华
 * @date 2022-03-01 16:32:14
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@SuppressWarnings("all")
public class ProcessorEntity extends SerializableBean {
    private static final long serialVersionUID = -3013768037305729417L;

    private String containerName;
    private Object processor;
    private ProcessorAssert processorAssert;
    private String key;
    private String description;
    private boolean defaultProcessor;
    private int ordered;

}
