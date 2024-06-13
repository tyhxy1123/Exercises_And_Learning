package com.javacode2020.lesson002.dynamicProxy.cglib;

import org.springframework.cglib.proxy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class CallBackFilterDemo {

    @Bean("proxy4")
    public static Service4 createService4Proxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service4.class);
        CallbackFilter filter = new CallbackFilter() {
            @Override
            public int accept(Method method) {
//                return 1;
                return method.getName().startsWith("incert") ? 0 : 1;
            }
        };
        Callback[] callbacks = {
                (MethodInterceptor) (o, method, objects, methodProxy) -> {
                    var start = System.nanoTime();
                    var result = methodProxy.invokeSuper(o, objects);
                    var end = System.nanoTime();
                    System.out.println(method + " took time: " + (end-start));
                    return result;
                },
                (FixedValue) () ->{
                    System.out.println("This is fixed value");
                    return "This is fixed value";
                }
        };
        System.out.println(callbacks[1].getClass().getMethods()[0].getName());
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(filter);
        return (Service4) enhancer.create();
    }

    public static void main(String[] args) {
        Service4 proxy = createService4Proxy();
        System.out.println("------------");
        proxy.incert1();
        System.out.println("------------");
        proxy.incert2();
        System.out.println("------------");
        proxy.get1();
        System.out.println("------------");
        proxy.get2();
    }
}
