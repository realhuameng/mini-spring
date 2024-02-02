package common;

import bean.UserService;
import cn.hutool.core.bean.BeanException;
import com.huameng.springframework.beans.factory.config.BeanPostProcessor;

import java.nio.file.attribute.UserPrincipalLookupService;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if("userService".equals(beanName)){
            UserService userService = (UserService)bean;
            userService.setLocation("222");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String BeanName) throws BeanException {
        return bean;
    }
}
