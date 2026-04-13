void main() {
    UserImpl user = new UserImpl();
    user.addUser("hjx");
    user.deleteUser("hjx");

    ProxyImpl proxy = new ProxyImpl(user);
    proxy.addUser("lwy");
    proxy.deleteUser("lwy");
}