package com.huameng.springframework.beans.factory.support;

import com.huameng.springframework.beans.BeansException;
import com.huameng.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer(); //创建代理对象的工具类
        enhancer.setSuperclass(beanDefinition.getBeanClass()); //设置要创建代理的父类
        enhancer.setCallback(new NoOp() { //回调
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
