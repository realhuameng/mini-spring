package com.huameng.springframework.context.support;

import cn.hutool.core.bean.BeanException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeanException
     */
    void refresh() throws BeanException;
}
