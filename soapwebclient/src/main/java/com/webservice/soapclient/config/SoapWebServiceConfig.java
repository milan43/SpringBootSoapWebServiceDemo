package com.webservice.soapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @author : Milan Paudyal
 * @since : 11/13/19, Wed
 **/

@Configuration
public class SoapWebServiceConfig {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.webservice.soapclient.schema");
        return marshaller;
    }

}
