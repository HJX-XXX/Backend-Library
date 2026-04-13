public class CommonSingleton {
    // 懒汉式 双重检验 + synchronized +volatile 保证线程安全
    private static volatile CommonSingleton singleton;

    public static CommonSingleton getInstance() {
        if (singleton == null) {
            synchronized ((CommonSingleton.class)) {
                if (singleton == null) {
                    singleton = new CommonSingleton();
                }
            }
        }
        return singleton;
    }

}