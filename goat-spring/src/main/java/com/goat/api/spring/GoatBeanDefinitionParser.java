package com.goat.api.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class GoatBeanDefinitionParser implements BeanDefinitionParser {

    private final Class<?> beanClass;

    GoatBeanDefinitionParser(Class beanClass){
        this.beanClass = beanClass;
    }

//    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        String userName=element.getAttribute("userName");
        String email=element.getAttribute("email");
        if(StringUtils.hasText(id)){
            builder.addPropertyValue("id",id);
        }
        if(StringUtils.hasText(userName)){
            builder.addPropertyValue("userName", userName);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email", email);
        }

    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        try {
            return parse(element, parserContext, beanClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass) {
        try {
            return parse(element, parserContext, beanClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
