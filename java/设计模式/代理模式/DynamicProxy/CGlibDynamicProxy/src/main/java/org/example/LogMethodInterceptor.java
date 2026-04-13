package org.example;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogMethodInterceptor implements MethodInterceptor {

    /**
     * 代理对象调用方法时，会自动执行此方法
     * @param obj         代理对象本身
     * @param method      被调用的真实对象的方法
     * @param args        方法参数
     * @param methodProxy 代理方法（用于调用父类方法）
     * @return            方法返回值
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGlib Proxy");
        Object result = methodProxy.invokeSuper(obj, args);
        return result;
    }
}
