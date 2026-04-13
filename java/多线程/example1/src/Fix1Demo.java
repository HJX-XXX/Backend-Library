public class Fix1Demo {
    // 将两个线程的执行顺序改为一致
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    static void main() {
        new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println(Thread.currentThread().getName() + "，持有锁A，请求锁B");
                try{ Thread.sleep(100);} catch (InterruptedException e) {} // 放大死锁概率
                synchronized (LOCK_B) {
                    System.out.println(Thread.currentThread().getName() + ",拿到锁B，执行业务");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println(Thread.currentThread().getName() + "，持有锁B，请求锁A");
                try{Thread.sleep(100);}catch (InterruptedException e) {}
                synchronized (LOCK_B) {
                    System.out.println(Thread.currentThread().getName() + ",拿到锁A，执行业务");
                }
            }
        }, "线程2").start();
    }
}
