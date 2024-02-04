package com.huameng.springframework.context;

import com.huameng.springframework.beans.BeansException;
import com.huameng.springframework.beans.factory.Aware;
import com.huameng.springframework.context.support.ApplicationContext;

/**
 * 实现此接口，能感知所属的ApplicationContext
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
