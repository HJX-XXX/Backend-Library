import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定窗口限流（1秒最多N次）
 */
public class FixedWindowLimiter {
    // 限流阈值
    private final int limit;
    // 窗口时间（毫秒）
    private final long windowMs = 1000;
    // 计数器
    private final AtomicInteger count = new AtomicInteger(0);
    // 窗口开始时间
    private long lastTime = System.currentTimeMillis();

    public FixedWindowLimiter(int limit) {
        this.limit = limit;
    }

    // 核心方法：true=通过 false=限流
    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();

        // 1. 超过窗口时间，重置窗口
        if (now - lastTime > windowMs) {
            count.set(0);
            lastTime = now;
        }

        // 2. 判断是否超过阈值
        if (count.get() < limit) {
            count.incrementAndGet();
            return true;
        }
        return false;
    }
}