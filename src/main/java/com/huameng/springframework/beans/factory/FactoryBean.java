package com.huameng.springframework.beans.factory;

public interface FactoryBean<T> {

    /**
     * 获取对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     * @return
     */
    Class<?> getObjectType();


    /**
     * 判断是否为单例对象
     * @return
     */
    boolean isSingleton();
}
