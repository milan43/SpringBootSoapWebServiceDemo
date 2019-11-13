package com.webservice.soapwebserver.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author : Milan Paudyal
 * @since : 11/13/19, Wed
 **/

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServelet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapWS/*");
    }

    /**
     * Define the xsd file location
     *
     * @return XsdSchema
     */
    @Bean
    public XsdSchema userSchema() {
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }

    @Bean("users") //this bean name will be useful to generate wsdl file as http://localhost:8081/soapWS/users.wsdl
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(xsdSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("UserServicePort");
        definition.setTargetNamespace("http://webservice.com/schema");
        return definition;
    }

}
