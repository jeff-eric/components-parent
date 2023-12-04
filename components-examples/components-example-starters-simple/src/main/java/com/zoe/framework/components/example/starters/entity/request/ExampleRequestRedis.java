package com.zoe.framework.components.example.starters.entity.request;

import com.zoe.framework.components.core.common.serializable.SerializableBean;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author 蒋时华
 * @date 2023-12-04 14:26:57
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ExampleRequestRedis extends SerializableBean {

    private String valStr;
    private Integer valInt;
    private Long valLong;
    private Boolean valBol;
    private LocalDateTime valData;

}
