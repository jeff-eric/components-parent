package com.zoe.framework.components.starter.metrics.configuration;

import io.github.mweirauch.micrometer.jvm.extras.ProcessMemoryMetrics;
import io.github.mweirauch.micrometer.jvm.extras.ProcessThreadMetrics;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author 蒋时华
 * @date 2020-05-11 20:00:01
 */
@Service
@EnableConfigurationProperties(MetricsProperties.class)
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MetricsAutoConfiguration {

    @Bean
    @ConditionalOnProperty(value = {"management.metrics.enable.process", "zoe.metrics.enabled"}, havingValue = "true", matchIfMissing = true)
    public MeterBinder processMemoryMetrics() {
        return new ProcessMemoryMetrics();
    }

    @Bean
    @ConditionalOnProperty(value = {"management.metrics.enable.process", "zoe.metrics.enabled"}, havingValue = "true", matchIfMissing = true)
    public MeterBinder processThreadMetrics() {
        return new ProcessThreadMetrics();
    }

}
