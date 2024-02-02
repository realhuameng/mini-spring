import bean.UserDao;
import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.huameng.springframework.beans.PropertyValue;
import com.huameng.springframework.beans.PropertyValues;
import com.huameng.springframework.beans.factory.config.BeanDefinition;
import com.huameng.springframework.beans.factory.config.BeanReference;
import com.huameng.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.huameng.springframework.core.io.DefaultResourceLoader;
import com.huameng.springframework.core.io.Resource;
import jdk.internal.util.xml.impl.Input;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class ApiTest {

    @Test
    public void test_BeanFactory(){
        //初始化
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //第一次获取
//        UserService userService = (UserService)beanFactory.getBean("userService");
//        userService.queryUserInfo();
        //第二次获取
        UserService userService_singleton = (UserService)beanFactory.getBean("userService","姓名");
        userService_singleton.queryUserInfo();


    }

    @Test
    public void test_BeanFactory02(){
        //初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //UserDao注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "1"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException{
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException{
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException{
        
    }

}
