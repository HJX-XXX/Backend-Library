/**
 * 令牌桶限流（生产标准）
 */
public class TokenBucketLimiter {
    private final int capacity;     // 桶最大容量
    private final int rate;         // 每秒生成令牌数
    private double tokens;          // 当前令牌数
    private long lastTime = System.currentTimeMillis();

    public TokenBucketLimiter(int rate, int capacity) {
        this.rate = rate;
        this.capacity = capacity;
        this.tokens = capacity;
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 1. 计算时间差，补充令牌
        double add = (now - lastTime) / 1000.0 * rate;
        tokens = Math.min(capacity, tokens + add);
        lastTime = now;

        // 2. 尝试取令牌
        if (tokens >= 1) {
            tokens--;
            return true;
        }
        return false;
    }
}
