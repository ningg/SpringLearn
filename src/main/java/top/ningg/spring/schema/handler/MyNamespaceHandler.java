package top.ningg.spring.schema.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import top.ningg.spring.schema.parser.SimpleDateFormatBeanDefinitionParser;

public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("dateformat", new SimpleDateFormatBeanDefinitionParser());
    }

}