public class UserImpl implements UserService{

    @Override
    public void addUser(String name) {
        System.out.println("添加用户" + name);
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("删除用户" + name);
    }
}
