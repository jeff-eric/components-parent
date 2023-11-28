package com.jphoebe.framework.components.starter.feign.protostuff.autoconfigure;

import com.jphoebe.framework.components.starter.feign.protostuff.constant.GlobalConfigConst;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author 蒋时华
 * @date 2020-05-18 12:22:55
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(GlobalConfigConst.HTTP2_PREFIX)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalHttp2Config {

    /*** 是否开启http2 */
    private Boolean enable;

    public GlobalHttp2Config() {
        this.enable = true;
    }
}
