import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fix2Demo {
    // 一次性申请所有锁
    private static final Lock LOCK_A = new ReentrantLock();
    private static final ReentrantLock LOCK_B = new ReentrantLock();

    private static boolean tryGetAllLocks(long timeout) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 循环尝试获取锁，直到超时
        while (System.currentTimeMillis() - start < timeout) {
            boolean gotA = LOCK_A.tryLock(10, TimeUnit.MILLISECONDS);
            if (gotA) {
                try {
                    boolean gotB = LOCK_B.tryLock(10, TimeUnit.MILLISECONDS);
                    if (gotB) {
                        return true;
                    }else {
                        LOCK_A.unlock();// 没拿到B 释放A
                    }
                } catch (InterruptedException e) {
                    LOCK_A.unlock();
                    throw e;
                }

            }
        }
        return false;
    }

    static void main() {
        new Thread(() -> {
            try {
                if (tryGetAllLocks(1000)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ",拿到所有锁");
                    } finally {
                        //释放所有锁
                        LOCK_A.unlock();
                        LOCK_B.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ",获取锁超时");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();

        new Thread(() -> {
            try {
                if (tryGetAllLocks(1000)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ",拿到所有锁");
                    } finally {
                        //释放所有锁
                        LOCK_A.unlock();
                        LOCK_B.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ",获取锁超时");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();

    }

}
