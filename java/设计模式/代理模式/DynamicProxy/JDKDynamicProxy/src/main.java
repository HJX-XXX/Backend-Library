import java.lang.reflect.Proxy;

void main() {
    UserImpl user = new UserImpl();
    // 创建InvocationHandler（传入真实对象）
    ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(user);
    // 动态生成代理对象
    UserService proxy = (UserService) Proxy.newProxyInstance(
            user.getClass().getClassLoader(),
            user.getClass().getInterfaces(),
            proxyInvocationHandler
    );
    proxy.addUser("hjx");
    proxy.deleteUser("lwy");
}