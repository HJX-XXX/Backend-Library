package org.example;

import net.sf.cglib.proxy.Enhancer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 创建 Enhancer 对象（CGLIB 的核心类，用于生成代理类）
        Enhancer enhancer = new Enhancer();
        // 设置父类（真实类）：CGLIB 通过继承真实类生成代理子类
        enhancer.setSuperclass(UserService.class);
        // 设置回调：传入 MethodInterceptor
        enhancer.setCallback(new LogMethodInterceptor());
        // 动态生成代理对象
        UserService proxy = (UserService) enhancer.create();
        // 调用代理对象的方法
        proxy.addUser("hjx");
        System.out.println("---");
        proxy.deleteUser("lwy");
    }
}
