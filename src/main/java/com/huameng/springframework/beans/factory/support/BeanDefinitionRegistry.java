package com.huameng.springframework.beans.factory.support;

import com.huameng.springframework.beans.BeansException;
import com.huameng.springframework.beans.factory.config.BeanDefinition;

import java.beans.Beans;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    boolean containBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();
}
