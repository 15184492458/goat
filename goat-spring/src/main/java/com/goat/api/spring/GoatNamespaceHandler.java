package com.goat.api.spring;

import com.goat.api.core.config.ServiceConfig;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class GoatNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
//        registerBeanDefinitionParser("service",new ServiceConfig());
    }
}
