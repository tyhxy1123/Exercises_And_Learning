package com.javacode2020.lesson002.dynamicProxy.cglib;

import org.springframework.cglib.proxy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class ProxyWithCallBackHelper {

    @Bean("proxyCallBackHelper")
    public Service4 provideService4ProxyWithCallBackHelper(){
        Enhancer enhancer = new Enhancer();
        Callback costTimeCallBack = (MethodInterceptor)(o, noNeed, arr, mp) -> {
            long startTime = System.nanoTime();
            var result = mp.invokeSuper(o, arr);
            long endTime = System.nanoTime();
            return "used time: " + (endTime-startTime);
        };
        Callback fixedValueCallBack = (FixedValue)()->{
            return "fixed value, no matter what you input...yeah";
        };

        CallbackHelper helper = new CallbackHelper(Service4.class, null) {
            @Override
            protected Object getCallback(Method method) {
                return method.getName().startsWith("incert") ? costTimeCallBack : fixedValueCallBack;
            }
        };
        enhancer.setSuperclass(Service4.class);
        enhancer.setCallbacks(helper.getCallbacks());
        enhancer.setCallbackFilter(helper);
        return (Service4) enhancer.create();
    }
}
