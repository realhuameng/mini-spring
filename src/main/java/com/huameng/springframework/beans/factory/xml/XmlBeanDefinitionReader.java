package com.huameng.springframework.beans.factory.xml;

import cn.hutool.core.getter.OptNullBasicTypeFromStringGetter;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.huameng.springframework.beans.BeansException;
import com.huameng.springframework.beans.PropertyValue;
import com.huameng.springframework.beans.factory.config.BeanDefinition;
import com.huameng.springframework.beans.factory.config.BeanReference;
import com.huameng.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.huameng.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.huameng.springframework.core.io.Resource;
import com.huameng.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry){
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader){
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinition(inputStream);
            }
        }catch(IOException | ClassNotFoundException e){
            throw new BeansException("IOException parsing XML document from" + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for(Resource resource : resources){
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }
    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinition(InputStream inputStream) throws ClassNotFoundException{
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for(int i=0;i<childNodes.getLength();i++){
            //判断元素
            if(!(childNodes.item(i) instanceof Element)) continue;
            //判断对象
            if(!"bean".equals(childNodes.item(i).getNodeName())) continue;

            //解析标签
            Element bean = (Element)childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            //增加对新增属性的读取
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");

            String beanScope = bean.getAttribute("scope");
            //获取class
            Class<?> clazz = Class.forName(className);
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if(StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if(StrUtil.isNotEmpty(beanScope)){
                beanDefinition.setScope(beanScope);
            }
            for(int j=0;j<bean.getChildNodes().getLength();j++){
                if(!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if(!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                Element property = (Element)bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);

            }

            if(getRegistry().containBeanDefinition(beanName)){
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            getRegistry().registerBeanDefinition(beanName, beanDefinition);


        }

    }
}
