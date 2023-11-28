package cn.auntec.framework.components.starter.mongodb.entity.version;

import cn.auntec.framework.components.util.constant.DateFormatConst;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * DO base entity by snow_flake id
 *
 * @author 蒋时华
 * @date 2019/6/26
 */
@Getter
@Setter
public abstract class AbstractTimeVersionBaseEntity<T> extends AbstractVersionBaseEntity<T> {

    private static final long serialVersionUID = -4024689623085796268L;

    /**
     * 创建人
     */
    public Long createBy;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateFormatConst.NORM_DATETIME_MS_PATTERN)
    @JsonFormat(pattern = DateFormatConst.NORM_DATETIME_MS_PATTERN)
    public LocalDateTime createTime;

    /**
     * 更新人
     */
    public Long updateBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = DateFormatConst.NORM_DATETIME_MS_PATTERN)
    @JsonFormat(pattern = DateFormatConst.NORM_DATETIME_MS_PATTERN)
    public LocalDateTime updateTime;

}
