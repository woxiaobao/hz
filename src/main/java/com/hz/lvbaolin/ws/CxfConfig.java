package com.hz.lvbaolin.ws;

import com.hz.lvbaolin.ws.webservice.PersonService;
import com.hz.lvbaolin.ws.webservice.impl.PersonServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * Created by master-lv on 2017/7/14.
 */

@Configuration
public class CxfConfig {

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), personService());
        endpoint.publish("/person");
        return endpoint;
    }
}
