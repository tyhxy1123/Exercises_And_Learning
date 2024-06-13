package com.javacode2020.lesson002.staticProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class serviceConfig {
    @Bean(name = "proxyA")
    @Autowired
    @Qualifier("serviceA")
    public ServiceProxy createServiceProxyA(IService serviceA){
        return new ServiceProxy(serviceA);
    }
    @Bean(name = "proxyB")
    @Autowired
    @Qualifier("serviceB")
    public ServiceProxy createServiceProxyB(IService serviceB){
        return new ServiceProxy(serviceB);
    }
}
