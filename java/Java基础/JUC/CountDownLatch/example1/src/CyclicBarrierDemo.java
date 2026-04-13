import java.util.concurrent.CountDownLatch;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        // 1. 设置倒计时初始值：3个任务需要完成
        CountDownLatch latch = new CountDownLatch(3);

        // 2. 启动3个并行子线程执行任务
        new Thread(new ConfigLoaderTask("数据库配置", latch)).start();
        new Thread(new ConfigLoaderTask("Redis配置", latch)).start();
        new Thread(new ConfigLoaderTask("MQ配置", latch)).start();

        System.out.println("主线程阻塞，等待所有配置加载完成...");
        // 3. 主线程阻塞，直到倒计时归0
        latch.await();
        System.out.println("所有配置加载完成，主线程启动业务服务！");
    }

    // 配置加载任务
    static class ConfigLoaderTask implements Runnable {
        private final String configName;
        private final CountDownLatch latch;

        public ConfigLoaderTask(String configName, CountDownLatch latch) {
            this.configName = configName;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // 模拟加载配置的耗时
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(configName + " 加载完成");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 【关键】任务完成，倒计时减1，必须放在finally里，避免异常导致永远无法归0
                latch.countDown();
            }
        }
    }
}
