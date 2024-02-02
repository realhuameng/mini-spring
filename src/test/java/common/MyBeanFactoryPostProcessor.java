package common;

import cn.hutool.core.bean.BeanException;
import com.huameng.springframework.beans.PropertyValue;
import com.huameng.springframework.beans.PropertyValues;
import com.huameng.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.huameng.springframework.beans.factory.config.BeanDefinition;
import com.huameng.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "111"));
    }
}
