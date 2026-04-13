public class main {
    static void main() throws InterruptedException{
        SlidingWindowLimiter limiter = new SlidingWindowLimiter(2); // 1秒最多2次
        for (int i = 0; i < 10; i++) {
            System.out.println("请求" + i + ": " + limiter.tryAcquire());
            Thread.sleep(300);
        }
    }
}
