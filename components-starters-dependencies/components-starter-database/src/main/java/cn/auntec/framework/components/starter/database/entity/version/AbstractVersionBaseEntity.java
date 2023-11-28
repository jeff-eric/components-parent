package cn.auntec.framework.components.starter.database.entity.version;

import cn.auntec.framework.components.starter.database.entity.AbstractBaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * DO base entity by snow_flake id
 *
 * @author 蒋时华
 * @date 2019/6/26
 */
@Getter
@Setter
public abstract class AbstractVersionBaseEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = -3062937558431776826L;

    @Version
    private Long version;


}
