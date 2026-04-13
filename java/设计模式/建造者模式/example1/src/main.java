public class main {
    static void main() {
        User user = User.builder().id(1L).age(25).name("hjx").email("test").phone("456").build();
        System.out.println(user);
    }
}
