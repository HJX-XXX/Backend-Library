import java.util.Arrays;

/**
 * 滑动窗口限流（更精准）
 */
public class SlidingWindowLimiter {
    private final int limit;
    private final int windowMs = 1000;  // 总窗口1秒
    private final int bucketNum = 10;    // 切10个小窗口
    private final int bucketMs = windowMs / bucketNum; // 每个100ms
    private final int[] buckets = new int[bucketNum];   // 小窗口计数
    private long lastTime = System.currentTimeMillis();

    public SlidingWindowLimiter(int limit) {
        this.limit = limit;
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 清空过期小窗口
        clearOldBucket(now);

        // 计算落在哪个小窗口
        int idx = (int) ((now / bucketMs) % bucketNum);
        buckets[idx]++;

        // 统计最近1秒总请求
        int sum = Arrays.stream(buckets).sum();
        return sum <= limit;
    }

    // 清空过期小窗口
    private void clearOldBucket(long now) {
        long diff = now - lastTime;
        if (diff > bucketMs) {
            int clearNum = (int) (diff / bucketMs);
            for (int i = 0; i < clearNum; i++) {
                int idx = (int) ((lastTime / bucketMs + i) % bucketNum);
                buckets[idx] = 0;
            }
            lastTime = now;
        }
    }
}
