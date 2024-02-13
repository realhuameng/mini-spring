package com.huameng.springframework.context.event;

import com.huameng.springframework.context.ApplicationEvent;
import com.huameng.springframework.context.support.ApplicationContext;

public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * 构建一个原型事件
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取引发事件的ApplicationContext
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
