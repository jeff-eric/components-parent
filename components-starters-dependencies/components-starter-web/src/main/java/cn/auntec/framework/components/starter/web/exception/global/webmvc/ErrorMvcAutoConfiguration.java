package cn.auntec.framework.components.starter.web.exception.global.webmvc;

import cn.auntec.framework.components.core.annotation.source.Snapshot;
import cn.auntec.framework.components.starter.web.config.GlobalExceptionConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link EnableAutoConfiguration Auto-configuration} to render errors via an MVC error
 * controller.
 *
 * @author Dave Syer
 * @author Andy Wilkinson
 * @author Stephane Nicoll
 * @author Brian Clozel
 */
@Configuration
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@ConditionalOnProperty(value = "auntec.exception.config.enable", havingValue = "true", matchIfMissing = true)
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties({ServerProperties.class, WebMvcProperties.class, GlobalExceptionConfig.class})
public class ErrorMvcAutoConfiguration {

    private final ServerProperties serverProperties;
    private final DispatcherServletPath dispatcherServletPath;
    private final List<ErrorViewResolver> errorViewResolvers;
    private final GlobalExceptionConfig globalExceptionConfig;

    public ErrorMvcAutoConfiguration(ServerProperties serverProperties,
                                     DispatcherServletPath dispatcherServletPath,
                                     ObjectProvider<ErrorViewResolver> errorViewResolvers, GlobalExceptionConfig globalExceptionConfig) {
        this.serverProperties = serverProperties;
        this.dispatcherServletPath = dispatcherServletPath;
        this.errorViewResolvers = errorViewResolvers.orderedStream()
                .collect(Collectors.toList());
        this.globalExceptionConfig = globalExceptionConfig;
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(value = AuntecErrorController.class,
            search = SearchStrategy.CURRENT)
    @Snapshot(message = "新版本未测试")
    public DefaultErrorAttributes errorAttributes() {
//        this.serverProperties.getError().isIncludeException();
        return new DefaultErrorAttributes();
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(value = AuntecErrorController.class,
            search = SearchStrategy.CURRENT)
    @ConditionalOnProperty(value = "auntec.exception.config.has-html-error", havingValue = "false", matchIfMissing = true)
    public AuntecErrorController basicErrorController(ErrorAttributes errorAttributes) {
        return new AuntecErrorController(errorAttributes, this.serverProperties.getError(),
                this.errorViewResolvers);
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean(value = AuntecErrorController.class,
            search = SearchStrategy.CURRENT)
    @ConditionalOnProperty(value = "auntec.exception.config.has-html-error", havingValue = "true", matchIfMissing = false)
    public AuntecErrorController basicErrorHtmlController(ErrorAttributes errorAttributes) {
        return new AuntecErrorHtmlController(errorAttributes, this.serverProperties.getError(),
                this.errorViewResolvers);
    }

}
