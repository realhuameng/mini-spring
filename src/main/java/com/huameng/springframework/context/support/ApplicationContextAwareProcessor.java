package com.huameng.springframework.context.support;

import cn.hutool.core.bean.BeanException;
import com.huameng.springframework.beans.factory.config.BeanPostProcessor;
import com.huameng.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String BeanName) throws BeanException {
        return bean;
    }
}
