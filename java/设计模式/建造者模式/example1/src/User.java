public class User {
    // 大量参数 用建造者模式构建
    private Long id;
    private String name;
    private  Integer age;
    private String email;
    private String phone;

    // 1.私有构造器 只能通过建造者创建对象
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // 2.提供静态方法 获取建造者
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    // 3.静态内部建造者类
    public static class  UserBuilder {
        private Long id;
        private String name;
        private  Integer age;
        private String email;
        private String phone;

        // !!!链式调用set方法 返回建造者本身
        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        // 最终构建方法 返回目标对象
        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
