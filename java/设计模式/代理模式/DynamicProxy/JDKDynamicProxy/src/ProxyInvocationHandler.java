import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现InvocationHandler，编写通用代理逻辑（可代理所有实现了接口的类）
public class ProxyInvocationHandler implements InvocationHandler {
    // 持有代理对象的真实引用
    private Object realObject;

    // 构造方法 传入真实对象
    public ProxyInvocationHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理");
        // 通过 反射 的方式调用真实对象的方法
        Object invoke = method.invoke(realObject, args);
        return invoke;
    }
}
