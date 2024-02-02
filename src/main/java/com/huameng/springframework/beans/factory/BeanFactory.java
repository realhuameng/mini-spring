package com.huameng.springframework.beans.factory;

import com.huameng.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;
    Object getBean(String name, Object... args) throws BeansException;
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}