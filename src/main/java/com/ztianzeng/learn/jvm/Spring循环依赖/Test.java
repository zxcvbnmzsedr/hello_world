package com.ztianzeng.learn.jvm.Spring循环依赖;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        AService as = new AServiceImpl();

        AService asProxy = (AService) Proxy.newProxyInstance(as.getClass().getClassLoader(), as.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(as, args);
            }
        });
        BService bs = new BServiceImpl();
        ((BServiceImpl) bs).setaService(asProxy);
        ((AServiceImpl) as).setbService(bs);
        bs.bb();
    }
}
