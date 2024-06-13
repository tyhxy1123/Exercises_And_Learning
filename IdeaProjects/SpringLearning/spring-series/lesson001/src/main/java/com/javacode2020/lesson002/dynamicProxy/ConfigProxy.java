package com.javacode2020.lesson002.dynamicProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Configuration
@ComponentScan
public class ConfigProxy {
    @Bean(value = "serviceProxy")
    public IService createIService() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
        var invocationHandler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("I'm InvocationHandler, the method called is: " + method.getName());
                return null;
            }
        };
        return proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
    }
    @Bean("serviceProxyEasy")
    public IService createIServiceEasy(){
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("I'm InvocationHandler, the method called is: " + method.getName());
                return null;
            }
        };
        return (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
    }
    @Bean("exampleProxyA")
    public IService createExampleProxyA(@Autowired @Qualifier("serviceA")IService sa){
        return CostTimeInvocationHandler.createProxy(sa, IService.class);
    }
    @Bean("exampleProxyB")
    public IService createExampleProxyB(@Autowired @Qualifier("serviceB") IService sb){
        return CostTimeInvocationHandler.createProxy(sb, IService.class);
    }
    @Bean("userService")
    public IUserService createUserService(){
        return new UserService();
    }
    @Bean("userProxy")
    public IUserService createUserServiceProxy(@Autowired @Qualifier("userService") IUserService userService){
        return CostTimeInvocationHandler.createProxy(userService, IUserService.class);
    }
}
