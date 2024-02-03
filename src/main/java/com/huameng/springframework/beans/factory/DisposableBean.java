package com.huameng.springframework.beans.factory;

import jdk.nashorn.internal.runtime.ECMAException;

public interface DisposableBean {

    void destroy() throws Exception;
}
