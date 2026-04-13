public class SimpleSingleton {
    // 使用静态内部类，利用类加载机制保证线程安全
    private static class Holder {
        private static final SimpleSingleton INSTANCE = new SimpleSingleton();
    }

    public static SimpleSingleton getInstance() {
        return Holder.INSTANCE;
    }

}
