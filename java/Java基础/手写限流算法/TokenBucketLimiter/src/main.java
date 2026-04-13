public class main {
    static void main() throws InterruptedException{
        TokenBucketLimiter limiter = new TokenBucketLimiter(2, 4); // 1秒最多2次
        for (int i = 0; i < 10; i++) {
            System.out.println("请求" + i + ": " + limiter.tryAcquire());
            Thread.sleep(200);
        }
    }
}
