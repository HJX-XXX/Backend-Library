import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 1. 设置需要等待3个线程，所有线程到齐后，先执行裁判的回调任务
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("所有运动员已到起跑线，裁判发令：开跑！");
        });

        // 2. 启动3个运动员线程，跑2轮比赛
        new Thread(new Runner("运动员A", barrier)).start();
        new Thread(new Runner("运动员B", barrier)).start();
        new Thread(new Runner("运动员C", barrier)).start();
    }

    // 运动员任务
    static class Runner implements Runnable {
        private final String name;
        private final CyclicBarrier barrier;

        public Runner(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                // 第一轮比赛
                System.out.println(name + " 到达第一轮起跑线，等待其他运动员");
                // 到达栅栏，阻塞等待所有线程到齐
                barrier.await();
                System.out.println(name + " 第一轮开跑！");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(name + " 第一轮完成！");

                // 第二轮比赛（体现循环复用特性）
                System.out.println(name + " 到达第二轮起跑线，等待其他运动员");
                barrier.await(); // 栅栏自动重置，直接复用
                System.out.println(name + " 第二轮开跑！");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(name + " 第二轮完成！");

            } catch (Exception e) {
                // 栅栏被打破、线程中断、超时都会抛出异常
                e.printStackTrace();
            }
        }
    }
}
