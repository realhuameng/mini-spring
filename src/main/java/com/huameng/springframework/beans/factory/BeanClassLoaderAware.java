package com.huameng.springframework.beans.factory;

/**
 * 实现此类，能感知所属的ClassLoader
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
