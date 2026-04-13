public class ProxyImpl implements UserService{

    UserService userService;

    // 关键！需要传入真实对象，编译时生成
    public ProxyImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addUser(String name) {
        System.out.println("代理类");
        userService.addUser(name);
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("代理类");
        userService.deleteUser(name);
    }
}
