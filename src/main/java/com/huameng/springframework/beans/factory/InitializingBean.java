package com.huameng.springframework.beans.factory;

public interface InitializingBean {

    /**
     * 属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
