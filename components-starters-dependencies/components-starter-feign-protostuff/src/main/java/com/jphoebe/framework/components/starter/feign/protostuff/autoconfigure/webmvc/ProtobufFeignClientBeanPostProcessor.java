package com.jphoebe.framework.components.starter.feign.protostuff.autoconfigure.webmvc;

import com.jphoebe.framework.components.starter.feign.protostuff.annotation.ProtostuffFeignClient;
import com.jphoebe.framework.components.util.value.data.CollectionUtil;
import com.jphoebe.framework.components.util.value.data.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.openfeign.FeignClientFactoryBean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 在feignclient 上 自动配置 FeignMessageConverterAutoConfiguration protostuff序列化支持配置类
 *
 * @author 蒋时华
 * @date 2020-05-14 13:14:34
 */
@Configuration
@Slf4j
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class ProtobufFeignClientBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        // 扫描有protostuffFeignClient的注解
        String[] beanNamesForAnnotation = ((DefaultListableBeanFactory) registry).getBeanNamesForAnnotation(ProtostuffFeignClient.class);
        List<String> serviceName = Arrays.asList(beanNamesForAnnotation);
        ListIterator<String> iterator = serviceName.listIterator();
        while (iterator.hasNext()) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(iterator.next());
            FeignClientFactoryBean feignClientFactoryBean = (FeignClientFactoryBean) beanDefinition.getAttribute("feignClientsRegistrarFactoryBean");
            String name = feignClientFactoryBean.getName();
            String contextId = feignClientFactoryBean.getContextId();
            iterator.set(StrUtil.blankToDefault(contextId, name) + ".FeignClientSpecification");
//            Object name = beanDefinition.getPropertyValues().get("name");
//            Object contextId = beanDefinition.getPropertyValues().get("contextId");
//            iterator.set(StrUtil.blankToDefault(contextId.toString(), name.toString()) + ".FeignClientSpecification");
        }
        // 自动配置protostuff 配置类
        serviceName.forEach(beanDefinitionName -> {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);
            ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
            ConstructorArgumentValues.ValueHolder indexedArgumentValues = constructorArgumentValues.getIndexedArgumentValues().get(1);
            Object[] configuration = (Object[]) indexedArgumentValues.getValue();
            ArrayList<Object> configurationList = CollectionUtil.toList(configuration);
            configurationList.add(FeignMessageConverterAutoConfiguration.class);
            indexedArgumentValues.setValue(configurationList.toArray());
        });
        log.debug(serviceName.toString());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
