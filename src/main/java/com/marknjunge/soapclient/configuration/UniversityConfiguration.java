package com.marknjunge.soapclient.configuration;

import com.marknjunge.soapclient.client.UniversityClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UniversityConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("universities.wsdl");
        return marshaller;
    }

    @Bean
    public UniversityClient universityClient(Jaxb2Marshaller marshaller){
        UniversityClient client = new UniversityClient();
        client.setDefaultUri("http://localhost/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
