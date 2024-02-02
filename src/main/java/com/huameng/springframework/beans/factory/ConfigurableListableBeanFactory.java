package com.huameng.springframework.beans.factory;

import com.huameng.springframework.beans.BeansException;
import com.huameng.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.huameng.springframework.beans.factory.config.BeanDefinition;
import com.huameng.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    void preInstantiateSingletons() throws BeansException;
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
