package com.huameng.springframework.beans.factory;

import com.huameng.springframework.beans.BeansException;

import java.beans.Beans;

/**
 * 实现此接口，能感知到所属的BeanFactory
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
