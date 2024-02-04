package com.huameng.springframework.beans.factory;

/**
 * 实现此类，能感知所属的BeanName
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String name);
}
