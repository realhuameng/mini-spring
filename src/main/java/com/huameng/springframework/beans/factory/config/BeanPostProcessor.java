package com.huameng.springframework.beans.factory.config;

import cn.hutool.core.bean.BeanException;

public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     * @param bean
     * @param BeanName
     * @return
     * @throws BeanException
     */
    Object postProcessAfterInitialization(Object bean, String BeanName) throws BeanException;
}
